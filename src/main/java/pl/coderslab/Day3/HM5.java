package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/HM5")
public class HM5 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String departure = request.getParameter("departure");
        StringTokenizer stringTokenizer = new StringTokenizer(departure, "#");
        String departureAirport = stringTokenizer.nextToken();
        String departureCode = stringTokenizer.nextToken();
        String departureTimezone = stringTokenizer.nextToken();
        String arrival = request.getParameter("arrival");
        stringTokenizer = new StringTokenizer(arrival, "#");
        String arrivalAirport = stringTokenizer.nextToken();
        String arrivalCode = stringTokenizer.nextToken();
        String arrivalTimezone = stringTokenizer.nextToken();
        String date = request.getParameter("date");
        int length = Integer.parseInt(request.getParameter("length"));
        double price = Double.parseDouble(request.getParameter("price"));
        if(!departureAirport.equals(arrivalAirport) && check(date) && price > 0) {
            LocalDateTime departureTime = LocalDateTime.parse(date);
            ZoneId departureId = ZoneId.of(departureTimezone);
            ZonedDateTime departureZonedTime = departureTime.atZone(departureId);
            ZoneId arrivalId = ZoneId.of(arrivalTimezone);
            ZonedDateTime arrivalZonedTime = departureZonedTime.withZoneSameInstant(arrivalId);
            ZonedDateTime arrivalTime =  arrivalZonedTime.plusHours(length);
            LocalDateTime result = arrivalTime.toLocalDateTime();
            LocalTime localTime = result.toLocalTime();
            Time time = Time.valueOf(localTime);
            Flight flight = new Flight(departureAirport + " " + date + " " + departureCode, arrivalAirport + " " + result + " " + arrivalCode, time, price);
            request.setAttribute("length", length);
            request.setAttribute("flight", flight);
            getServletContext().getRequestDispatcher("/HM5Flight.jsp")
                    .forward(request, response);
        } else {
            String wrong = "Niepoprawne dane";
            AirportDao airportDao = new AirportDao();
            List<Airport> airports = airportDao.getList();
            request.setAttribute("airports", airports);
            request.setAttribute("wrong", wrong);
            getServletContext().getRequestDispatcher("/HM5.jsp")
                    .forward(request, response);
        }
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

    public boolean check(String datetime){
        String regex = "(2018){1}-[0-1][0-9]-[0-3][0-9][T][0-2][0-9]:[0-5][0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(datetime);
        return matcher.matches();
    }
}
