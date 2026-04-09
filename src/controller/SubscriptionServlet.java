package controller;

import model.Subscription;
import service.SubscriptionService;

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
public class SubscriptionServlet extends HttpServlet {

    private SubscriptionService subscriptionService = new SubscriptionService();

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
            List<Subscription> subs = null;
            if ("all".equals(action)) {
                subs = subscriptionService.getAllSubscriptions();
            } else if ("byMember".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                subs = subscriptionService.getSubscriptionsByMember(id);
            }

            if (subs != null) {
                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < subs.size(); i++) {
                    Subscription s = subs.get(i);
                    json.append("{")
                        .append("\"subscriptionId\":").append(s.getSubscriptionId()).append(",")
                        .append("\"memberId\":").append(s.getMemberId()).append(",")
                        .append("\"memberName\":\"").append(escapeStr(s.getMemberName())).append("\",")
                        .append("\"subscriptionType\":\"").append(escapeStr(s.getSubscriptionType())).append("\",")
                        .append("\"startDate\":\"").append(escapeStr(s.getStartDate())).append("\",")
                        .append("\"endDate\":\"").append(escapeStr(s.getEndDate())).append("\",")
                        .append("\"amount\":").append(s.getAmount()).append(",")
                        .append("\"status\":\"").append(escapeStr(s.getStatus())).append("\"")
                        .append("}");
                    if (i < subs.size() - 1) json.append(",");
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
            if ("add".equals(action)) {
                int memberId = Integer.parseInt(request.getParameter("memberId"));
                String type = request.getParameter("type");
                String startDate = request.getParameter("startDate");
                String endDate = request.getParameter("endDate");
                
                boolean success = subscriptionService.addSubscription(memberId, type, startDate, endDate);
                response.getWriter().write("{\"success\":" + success + "}");
            } else if ("updateStatus".equals(action)) {
                int subId = Integer.parseInt(request.getParameter("subscriptionId"));
                String status = request.getParameter("status");
                boolean success = subscriptionService.updateStatus(subId, status);
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
