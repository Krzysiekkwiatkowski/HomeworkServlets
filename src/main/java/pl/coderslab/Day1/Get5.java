package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get5", urlPatterns = "/Get5")
public class Get5 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String param1 = request.getParameter("company");
        String[] param2 = request.getParameterValues("learn");
        if(param1 != null){
            response.getWriter().append("company:" + "</br>");
            response.getWriter().append("- " + param1 + "</br>");
            response.getWriter().append("learn:" + "</br>");
            for (String language : param2) {
                response.getWriter().append("- " + language + "</br>");
            }
        } else {
            response.sendRedirect("index2.html");
        }
    }
}
