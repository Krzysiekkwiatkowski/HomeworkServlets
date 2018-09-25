package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Sess07")
public class Sess07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        boolean point = false;
        String[] capitols = {"Berlin", "Praga", "Bratysława", "Kijów", "Mińsk", "Wilno", "Moskwa"};
        String capitol = request.getParameter("capitol");
        int correct;
        int counter;
        HttpSession session = request.getSession();
        String correctCheck = String.valueOf(session.getAttribute("correct"));
        if(correctCheck.equals("null")){
            correct = 0;
        } else {
            correct = Integer.parseInt(correctCheck);
        }
        counter = (int) session.getAttribute("counter");
        if(capitols[counter].equals(capitol)){
            correct++;
            point = true;
        }
        counter++;
        session.setAttribute("point", point);
        session.setAttribute("correct", correct);
        session.setAttribute("counter", counter);
        response.sendRedirect("Sess07");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String[] countries = {"Niemcy", "Czechy", "Słowacja", "Ukraina", "Białoruś", "Litwa", "Rosja"};
        int counter;
        boolean point = false;
        HttpSession session = request.getSession();
        String pointCheck = String.valueOf(session.getAttribute("point"));
        if(pointCheck.equals("null")){
            point = false;
        } else {
            point = (boolean) session.getAttribute("point");
        }
        String counterCheck = String.valueOf(session.getAttribute("counter"));
        if(counterCheck.equals("null")){
            counter = 0;
        } else {
            counter = Integer.parseInt(counterCheck);
        }
        if(counter < countries.length) {
            response.getWriter().append("<form action=\"/Sess07\" method=\"post\">\n" +
                    "    Podaj stolicę dla państwa: " + countries[counter] + "<input type=\"text\" name=\"capitol\">\n" +
                    "    <input type=\"submit\" value=\"Gotowe\">\n" +
                    "</form>");
            if(counter > 0) {
                if (point == true) {
                    response.getWriter().append("Poprawna odpowiedź");
                } else if (point == false) {
                    response.getWriter().append("Niepoprawna odpowiedź");
                }
            }
        } else {
            int correct = (int) session.getAttribute("correct");
            response.getWriter().append("Poprawnych odpowiedzi: " + correct);
        }
        session.setAttribute("counter", counter);
        session.setAttribute("countries", countries);
    }
}
