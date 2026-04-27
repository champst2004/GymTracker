package controller;

import model.Trainer;
import service.TrainerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TrainerServlet extends HttpServlet {

    private TrainerService trainerService = new TrainerService();

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
                List<Trainer> trainers = trainerService.getAllTrainers();
                StringBuilder json = new StringBuilder("[");
                for (int i = 0; i < trainers.size(); i++) {
                    Trainer t = trainers.get(i);
                    json.append("{")
                        .append("\"trainerId\":").append(t.getTrainerId()).append(",")
                        .append("\"name\":\"").append(escapeStr(t.getName())).append("\",")
                        .append("\"phone\":\"").append(escapeStr(t.getPhone())).append("\",")
                        .append("\"email\":\"").append(escapeStr(t.getEmail())).append("\",")
                        .append("\"specialization\":\"").append(escapeStr(t.getSpecialization())).append("\"")
                        .append("}");
                    if (i < trainers.size() - 1) json.append(",");
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
                Trainer t = new Trainer();
                t.setName(request.getParameter("name"));
                t.setPhone(request.getParameter("phone"));
                t.setEmail(request.getParameter("email"));
                t.setSpecialization(request.getParameter("specialization"));
                
                boolean success = trainerService.addTrainer(t);
                response.getWriter().write("{\"success\":" + success + "}");
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean success = trainerService.deleteTrainer(id);
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
