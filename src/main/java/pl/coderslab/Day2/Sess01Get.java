package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Sess01Get")
public class Sess01Get extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object object = session.getAttribute("counter");
        if(object != null) {
            int counter = (int) object;
            counter++;
            response.getWriter().append("Wartość counter = " + counter);
            session.setAttribute("counter", counter);
        } else {
            response.getWriter().append("Brak danych");
        }
    }
}
