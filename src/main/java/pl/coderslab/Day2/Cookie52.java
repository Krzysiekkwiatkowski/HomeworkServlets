package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie52", urlPatterns = "/cookie52")
public class Cookie52 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Cookie[] cookies = request.getCookies();
        int counter = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("firstPage")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                response.getWriter().append("Witaj na drugiej stronie");
                counter++;
            }
        }
        if(counter == 0){
            response.sendRedirect("/cookie51?cheater=true");
        }
    }
}
