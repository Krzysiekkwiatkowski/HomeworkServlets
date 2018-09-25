package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Sess06")
public class Sess06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int sum = Integer.parseInt(request.getParameter("sum"));
        int subtract = Integer.parseInt(request.getParameter("subtract"));
        int multiply = Integer.parseInt(request.getParameter("multiply"));
        String isCorrect = "";
        HttpSession session = request.getSession();
        int number1 = (int) session.getAttribute("number1");
        int number2 = (int) session.getAttribute("number2");
        if(sum == number1 + number2){
            isCorrect = "Correct";
        } else {
            isCorrect = "Wrong";
        }
        response.getWriter().append(number1 + " + " + number2 + " = " + sum + " " + isCorrect + "</br>");
        if(subtract == number1 - number2){
            isCorrect = "Correct";
        } else {
            isCorrect = "Wrong";
        }
        response.getWriter().append(number1 + " - " + number2 + " = " + subtract + " " + isCorrect + "</br>");
        if(multiply == number1 * number2){
            isCorrect = "Correct";
        } else {
            isCorrect = "Wrong";
        }
        response.getWriter().append(number1 + " + " + number2 + " = " + multiply + " " + isCorrect + "</br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Random random = new Random();
        int number1 = random.nextInt(980) + 20;
        int number2 = random.nextInt(980) + 20;
        HttpSession session = request.getSession();
        session.setAttribute("number1", number1);
        session.setAttribute("number2", number2);
        response.getWriter().append("<form action=\"/Sess06\" method=\"post\">\n" +
                "    " + number1 + " + " + number2 + " = <input type=\"number\" name=\"sum\"></br>\n" +
                "    " + number1 + " - " + number2 + " <input type=\"number\" name=\"subtract\"></br>\n" +
                "    " + number1 + " * " + number2 + " <input type=\"number\" name=\"multiply\"></br>\n" +
                "    <input type=\"submit\" value=\"Gotowe\">\n" +
                "</form>");
    }
}
