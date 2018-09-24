package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Get61", urlPatterns = "/Get61")
public class Get61 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        for (int i = 1980; i < 2011; i++) {
            String year = "localhost:8080/Get62?year=" + i;
            String redirect = "<a href=\"" + year + "\"" + "> Link do roku " + i + "</a>";
            response.getWriter().append(redirect + "</br>");
        }
    }
}
