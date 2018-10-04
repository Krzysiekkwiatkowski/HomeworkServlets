package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@WebServlet("/HM5")
public class HM5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");
        String date = request.getParameter("date");
        int length = Integer.parseInt(request.getParameter("length"));
        double price = Double.parseDouble(request.getParameter("price"));
        response.getWriter().append(departure + " " + arrival + " " + date + " " + length + " " + price);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        AirportDao airportDao = new AirportDao();
        List<Airport> airports = airportDao.getList();
        request.setAttribute("airports", airports);
        getServletContext().getRequestDispatcher("/HM5.jsp")
                .forward(request, response);
    }
}
