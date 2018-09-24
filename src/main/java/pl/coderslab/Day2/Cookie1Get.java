package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie1Get", urlPatterns = "/showCookie")
public class Cookie1Get extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        int counter = 0;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("User")){
                response.getWriter().append(cookie.getValue());
                counter = 1;
            }
        }
        if(counter == 0){
            response.getWriter().append("Nie ma takiego ciasteczka");
        }
    }
}
