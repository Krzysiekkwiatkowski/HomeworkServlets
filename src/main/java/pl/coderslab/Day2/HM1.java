package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HM1")
public class HM1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        double value = Double.parseDouble(request.getParameter("value"));
        String change = request.getParameter("change");
        if(change.equals("eu")){
            response.getWriter().append("Kwota wynosi " + value / 0.85);
        }
        if(change.equals("ue")){
            response.getWriter().append("Kwota wynosi " + value / 1.17);
        }
        if(change.equals("ep")){
            response.getWriter().append("Kwota wynosi " + value * 4.28);
        }
        if(change.equals("pe")){
            response.getWriter().append("Kwota wynosi " + value / 4.29);
        }
        if(change.equals("up")){
            response.getWriter().append("Kwota wynosi " + value * 3.64);
        }
        if(change.equals("pu")){
            response.getWriter().append("Kwota wynosi " + value / 3.65);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.sendRedirect("/HM1.html");
    }
}
