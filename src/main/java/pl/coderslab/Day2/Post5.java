package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Post5", urlPatterns = "/Post5")
public class Post5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("convertionType");
        double degrees = Double.parseDouble(request.getParameter("degrees"));
        if(type.equals("CelcToFahr")){
            double result = (9.0 * degrees)/ 5.0 + 32.0;
            response.getWriter().append(degrees + " stopni C to " + result + " stopni F");
        } else {
            double result = (5.0 * (degrees - 32))/ 9.0;
            response.getWriter().append(degrees + " stopni F to " + result + " stopni C");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index_5.html");
    }
}
