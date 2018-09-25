package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Sess02")
public class Sess02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int grade = Integer.parseInt(request.getParameter("grade"));
        HttpSession session = request.getSession();
        if (grade > 0 && grade < 7) {
            int[] grades = (int[]) session.getAttribute("grades");
            if (grades != null) {
                int[] newGrades = new int[grades.length + 1];
                for (int i = 0; i < grades.length; i++) {
                    newGrades[i] = grades[i];
                }
                newGrades[grades.length] = grade;
                session.setAttribute("grades", newGrades);
            } else {
                int[] newGrades = new int[1];
                newGrades[0] = grade;
                session.setAttribute("grades", newGrades);
            }
        }
        response.sendRedirect("/Sess02");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("<form action=\"/Sess02\" method=\"post\">\n" +
                "    Ocena: <input type=\"number\" name=\"grade\">\n" +
                "    <input type=\"submit\" value=\"Dodaj\">\n" +
                "</form> ");
        HttpSession session = request.getSession();
        double counter = 0.0;
        int sum = 0;
        double avg = 0.0;
        int[] grades = (int[]) session.getAttribute("grades");
        if (grades != null) {
            for (int number : grades) {
                sum += number;
                counter++;
            }
            avg = sum / counter;
            response.getWriter().append("AVG: " + avg + "</br>");
            response.getWriter().append("Numbers:" + "</br>");
            for (int number : grades) {
                response.getWriter().append(number + "</br>");
            }
        }
    }
}


