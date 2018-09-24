package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get63", urlPatterns = "/Get63")
public class Get63 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int year = Integer.parseInt(request.getParameter("year"));
        int mix = Integer.parseInt(request.getParameter("mix"));
        int result = year + mix;
        response.getWriter().append("Rok to: " + result);
    }
}
