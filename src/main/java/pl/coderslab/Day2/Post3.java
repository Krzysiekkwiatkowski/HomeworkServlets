package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Post3", urlPatterns = "/Post3")
public class Post3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        int c = Integer.parseInt(request.getParameter("c"));
        double delta = Math.pow(b*b-4.0*a*c, 0.5);
        if(delta > 0) {
            double one = (-b + delta) / 2.0;
            double two = (-b - delta) / 2.0;
            response.getWriter().append("Miejsca zerowe " + one + " oraz " + two);
        } else if(delta == 0){
            double one = -b / 2.0;
            response.getWriter().append("Miejsce zerowe " + one);
        } else {
            response.getWriter().append("Brak miejsc zerowych!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index_3.html");
    }
}
