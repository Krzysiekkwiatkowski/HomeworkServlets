package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Get4", urlPatterns = "/Get4")
public class Get4 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try {
            String numberString = request.getParameter("page");
            if (numberString != null) {
                int numberValue = Integer.parseInt(numberString);
                response.getWriter().append("Wartość została przesłana");
                ArrayList<Integer> numbers = new ArrayList<>();
                for (int i = 1; i <= numberValue; i++) {
                    if (numberValue % i == 0) {
                        numbers.add(i);
                    }
                }
                for (int number : numbers) {
                    response.getWriter().append("</br>" + number);
                }
            } else {
                response.sendRedirect("index1.html");
            }

        } catch (NumberFormatException e) {
            response.getWriter().append("Nie przesłano poprawnej wartości");
        }
    }
}
