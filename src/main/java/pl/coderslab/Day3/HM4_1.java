package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/HM4_1")
public class HM4_1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie nextVisit = new Cookie("nextVisit", "");
        response.addCookie(nextVisit);
        Cookie[] cookies = request.getCookies();
        boolean isNextVisit = false;
        String greeting = "";
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("language")){
                greeting = cookie.getValue();
                if(greeting.equals("en")) {
                    response.getWriter().append("Hello");
                    isNextVisit = true;
                } else if(greeting.equals("de")){
                    response.getWriter().append("Ehre");
                    isNextVisit = true;
                } else if(greeting.equals("es")){
                    response.getWriter().append("Hola");
                    isNextVisit = true;
                } else if(greeting.equals("fr")){
                    response.getWriter().append("Bienvenue");
                    isNextVisit = true;
                }
            }
        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("nextVisit") && isNextVisit == false){
                response.getWriter().append("Cześć");
                isNextVisit = true;
            }
        }
        if(!isNextVisit) {
            response.getWriter().append("<form action=\"HM4_2\" method=\"post\">\n" +
                    "    <select name=\"language\">\n" +
                    "        <option value=\"en\"> English </option>\n" +
                    "        <option value=\"pl\"> Poland </option>\n" +
                    "        <option value=\"de\"> Germany </option>\n" +
                    "        <option value=\"es\"> Spain </option>\n" +
                    "        <option value=\"fr\"> France </option>\n" +
                    "    </select>\n" +
                    "    <input type=\"submit\" value=\"Choose\">\n" +
                    "</form>");
        }
    }
}
