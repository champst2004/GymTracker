package controller;

import model.Member;
import service.MemberService;

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
public class MemberServlet extends HttpServlet {

    private MemberService memberService = new MemberService();

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
            if ("list".equals(action)) {
                List<Member> members = memberService.getAllMembers();
                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < members.size(); i++) {
                    Member m = members.get(i);
                    json.append("{")
                        .append("\"memberId\":").append(m.getMemberId()).append(",")
                        .append("\"name\":\"").append(escapeStr(m.getName())).append("\",")
                        .append("\"phone\":\"").append(escapeStr(m.getPhone())).append("\",")
                        .append("\"email\":\"").append(escapeStr(m.getEmail())).append("\",")
                        .append("\"weight\":").append(m.getWeight()).append(",")
                        .append("\"gender\":\"").append(escapeStr(m.getGender())).append("\",")
                        .append("\"joinDate\":\"").append(escapeStr(m.getJoinDate())).append("\",")
                        .append("\"trainerId\":").append(m.getTrainerId()).append(",")
                        .append("\"trainerName\":\"").append(escapeStr(m.getTrainerName())).append("\"")
                        .append("}");
                    if (i < members.size() - 1) json.append(",");
                }
                json.append("]");
                response.getWriter().write(json.toString());
            } else if ("get".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Member m = memberService.getMemberById(id);
                if (m != null) {
                    StringBuilder json = new StringBuilder("{");
                    json.append("\"memberId\":").append(m.getMemberId()).append(",")
                        .append("\"name\":\"").append(escapeStr(m.getName())).append("\",")
                        .append("\"phone\":\"").append(escapeStr(m.getPhone())).append("\",")
                        .append("\"email\":\"").append(escapeStr(m.getEmail())).append("\",")
                        .append("\"weight\":").append(m.getWeight()).append(",")
                        .append("\"gender\":\"").append(escapeStr(m.getGender())).append("\",")
                        .append("\"joinDate\":\"").append(escapeStr(m.getJoinDate())).append("\",")
                        .append("\"trainerId\":").append(m.getTrainerId()).append(",")
                        .append("\"trainerName\":\"").append(escapeStr(m.getTrainerName())).append("\"")
                        .append("}");
                    response.getWriter().write(json.toString());
                } else {
                    response.getWriter().write("{}");
                }
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
            if ("add".equals(action)) {
                Member m = new Member();
                m.setName(request.getParameter("name"));
                m.setPhone(request.getParameter("phone"));
                m.setEmail(request.getParameter("email"));
                m.setWeight(Double.parseDouble(request.getParameter("weight")));
                m.setGender(request.getParameter("gender"));
                m.setJoinDate(request.getParameter("joinDate"));
                String tIdStr = request.getParameter("trainerId");
                if (tIdStr != null && !tIdStr.isEmpty()) {
                    m.setTrainerId(Integer.parseInt(tIdStr));
                }
                boolean success = memberService.addMember(m);
                response.getWriter().write("{\"success\":" + success + "}");
            } else if ("update".equals(action)) {
                Member m = new Member();
                m.setMemberId(Integer.parseInt(request.getParameter("memberId")));
                m.setName(request.getParameter("name"));
                m.setPhone(request.getParameter("phone"));
                m.setEmail(request.getParameter("email"));
                m.setWeight(Double.parseDouble(request.getParameter("weight")));
                m.setGender(request.getParameter("gender"));
                m.setJoinDate(request.getParameter("joinDate"));
                String tIdStr = request.getParameter("trainerId");
                if (tIdStr != null && !tIdStr.isEmpty()) {
                    m.setTrainerId(Integer.parseInt(tIdStr));
                }
                boolean success = memberService.updateMember(m);
                response.getWriter().write("{\"success\":" + success + "}");
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean success = memberService.deleteMember(id);
                response.getWriter().write("{\"success\":" + success + "}");
            } else if ("assignTrainer".equals(action)) {
                int mId = Integer.parseInt(request.getParameter("memberId"));
                int tId = Integer.parseInt(request.getParameter("trainerId"));
                boolean success = memberService.assignTrainer(mId, tId);
                response.getWriter().write("{\"success\":" + success + "}");
            } else if ("removeTrainer".equals(action)) {
                int mId = Integer.parseInt(request.getParameter("memberId"));
                boolean success = memberService.removeTrainer(mId);
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
