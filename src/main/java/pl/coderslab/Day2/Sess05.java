package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Sess05")
public class Sess05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        int result = Integer.parseInt(request.getParameter("result"));
        int captcha = (int) session.getAttribute("captcha");
        response.getWriter().append(name + " - " + surname + " - " + email + " ");
        if(result == captcha){
            response.getWriter().append("Poprawny wynik");
        } else {
            response.getWriter().append("Niepoprawny wynik");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Random random = new Random();
        int number1 = random.nextInt(101);
        int number2 = random.nextInt(101);
        response.getWriter().append("<form action=\"/Sess05\" method=\"post\">\n" +
                "    Imię: <input type=\"text\" name=\"name\">\n" +
                "    Nazwisko: <input type=\"text\" name=\"surname\">\n" +
                "    Email: <input type=\"text\" name=\"email\">\n" +
                "    Wpisz poniżej sumę: " + number1 + " + " + number2 + "<input type=\"number\" name=\"result\">\n" +
                "    <input type=\"submit\" value=\"Wyślij\">\n" +
                "</form>");
        HttpSession session = request.getSession();
        int captcha = number1 + number2;
        session.setAttribute("captcha", captcha);
    }
}
