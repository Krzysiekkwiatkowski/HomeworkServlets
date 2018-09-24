package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie51", urlPatterns = "/cookie51")
public class Cookie51 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Cookie cookie = new Cookie("firstPage", "true");
        response.addCookie(cookie);
        response.getWriter().append("<a href=\"http://localhost:8080/cookie52\"> Druga strona </a>");
        String cheater = request.getParameter("cheater");
        if(cheater.equals("true")){
            response.getWriter().append("</br>" + "Nie odwiedziłeś jeszcze tej strony");
        }
    }
}
