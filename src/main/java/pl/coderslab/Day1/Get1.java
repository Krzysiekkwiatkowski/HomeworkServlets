package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get1", urlPatterns = "/Get1")
public class Get1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String startNumber = request.getParameter("start");
        String endNumber = request.getParameter("end");
        try {
            int start = Integer.parseInt(startNumber);
            int end = Integer.parseInt(endNumber);
            for (int i = start; i < end + 1; i++) {
                response.getWriter().append(i + "<br>");
            }
        } catch (NumberFormatException e) {
            response.getWriter().append("Brak przesłanych zmiennych");
        }

    }
}
