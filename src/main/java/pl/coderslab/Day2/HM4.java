package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HM4")
public class HM4 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        boolean cookieExists = false;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("visits")){
                cookieExists = true;
            }
        }
        if(!cookieExists){
            response.getWriter().append("Witaj pierwszy raz na naszej stronie");
            Cookie cookie = new Cookie("visits", "1");
            cookie.setMaxAge(31536000);
            response.addCookie(cookie);
        } else {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("visits")){
                    int value = Integer.parseInt(cookie.getValue());
                    response.getWriter().append("Witaj, odwiedziłeś nas już " + value + " razy");
                    value++;
                    cookie.setValue(String.valueOf(value));
                    response.addCookie(cookie);
                } else {

                }
            }
        }
    }
}
