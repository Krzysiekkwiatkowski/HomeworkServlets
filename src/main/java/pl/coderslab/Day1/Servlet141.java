package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Servlet141", urlPatterns = "/Servlet041")
public class Servlet141 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        int id = random.nextInt(8);
        String address = "http://localhost:8080/Servlet042?id=" + id;
        response.sendRedirect(address);
    }
}
