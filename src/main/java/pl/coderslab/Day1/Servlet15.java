package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@WebServlet(name = "Servlet15", urlPatterns = "/Servlet15")
public class Servlet15 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int[] numberTable = new int[10];
        int[] sortedTable = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(100) + 1;
            numberTable[i] = number;
            sortedTable[i] = number;
        }
        Arrays.sort(sortedTable);
        response.getWriter().append("<table border=\"1px\">");
        for (int i = 0; i < numberTable.length; i++) {
            response.getWriter().append("<tr>\n" +
                    "        <td>" + numberTable[i] + "</td>\n" +
                    "        <td>" + sortedTable[i] + "</td>\n" +
                    "    </tr>");
        }
        response.getWriter().append("</table>");
    }
}
