package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/HM2")
public class HM2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String value = request.getParameter("value");
        int[] numbers = new int[value.length()];
        int sum = 0;
        int counter = 0;
        for (int i = value.length() - 1; i > -1; i--) {
            if(value.charAt(i) == '0' || value.charAt(i) == '1'){
                int number = Character.getNumericValue(value.charAt(i));
                numbers[value.length() - 1 - i] = number;
            } else {
                response.getWriter().append("Niepoprawna wartość!");
                break;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i] * (Math.pow(2, counter));
            counter++;
        }
        response.getWriter().append(value + " to liczba " + sum);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.sendRedirect("/HM2.html");
    }
}
