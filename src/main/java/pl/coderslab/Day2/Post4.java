package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@WebServlet(name = "Post4", urlPatterns = "/Post4")
public class Post4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] numbers = request.getParameterValues("numbers");
        ArrayList<Integer> numberList = new ArrayList<>();
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                numberList.add(num);
            } catch (NumberFormatException e) {
                continue;
            }
        }
        int[] numbersTable = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numbersTable[i] = numberList.get(i);
        }
        Arrays.sort(numbersTable);
        for (int fromTable : numbersTable){
            response.getWriter().append(fromTable + "\n");
        }
    }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            Random random = new Random();
            int params = random.nextInt(6) + 5;
            response.getWriter().append("<form action='/Post4' method='post'>\n");
            for (int i = 0; i < params; i++) {
                response.getWriter().append("<input name='numbers'/><br/>\n");
            }
            response.getWriter().append("<input type='submit'/>\n" +
                    "</form>");
        }
    }
