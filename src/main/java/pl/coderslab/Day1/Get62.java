package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Get62", urlPatterns = "/Get62")
public class Get62 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String year = request.getParameter("year");
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int mix = random.nextInt(21) - 10;
            String link = "localhost:8080/Get63?year=" + year + "&mix=" + mix;
            String redirect = "<a href=\"" + link + "\"" + "> Rok " + year + ", mix " + mix + "</a>";
            response.getWriter().append(redirect + "</br>");
        }
    }
}
