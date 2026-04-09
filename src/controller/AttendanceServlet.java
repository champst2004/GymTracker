package controller;

import model.Attendance;
import service.AttendanceServiceImpl;
import service.IAttendanceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author GymTracker
 * @version 1.0
 */
public class AttendanceServlet extends HttpServlet {

    private IAttendanceService attendanceService = new AttendanceServiceImpl();

    private boolean checkAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedIn") == null || !(boolean)session.getAttribute("loggedIn")) {
            response.sendError(401, "Unauthorized");
            return false;
        }
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!checkAuth(request, response)) return;
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            String action = request.getParameter("action");
            List<Attendance> list = null;
            if ("all".equals(action)) {
                list = attendanceService.getAllAttendance();
            } else if ("byMember".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                list = attendanceService.getAttendanceByMember(id);
            }

            if (list != null) {
                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < list.size(); i++) {
                    Attendance a = list.get(i);
                    json.append("{")
                        .append("\"attendanceId\":").append(a.getAttendanceId()).append(",")
                        .append("\"memberId\":").append(a.getMemberId()).append(",")
                        .append("\"memberName\":\"").append(escapeStr(a.getMemberName())).append("\",")
                        .append("\"checkInTime\":\"").append(escapeStr(a.getCheckInTime())).append("\"")
                        .append("}");
                    if (i < list.size() - 1) json.append(",");
                }
                json.append("]");
                response.getWriter().write(json.toString());
            }
        } catch (Exception e) {
            response.getWriter().write("{\"success\":false,\"message\":\"" + escapeStr(e.getMessage()) + "\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!checkAuth(request, response)) return;
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            String action = request.getParameter("action");
            if ("mark".equals(action)) {
                Attendance a = new Attendance();
                a.setMemberId(Integer.parseInt(request.getParameter("memberId")));
                
                boolean success = attendanceService.markAttendance(a);
                response.getWriter().write("{\"success\":" + success + "}");
            }
        } catch (Exception e) {
            response.getWriter().write("{\"success\":false,\"message\":\"" + escapeStr(e.getMessage()) + "\"}");
        }
    }

    private String escapeStr(String str) {
        if (str == null) return "";
        return str.replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "");
    }
}
