package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie7", urlPatterns = "/rememberMe")
public class Cookie7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        response.getWriter().append("Cześć " + name);
        String remember = request.getParameter("remember");
        if(!remember.equals(null)){
            Cookie cookie = new Cookie("remember", name);
            response.addCookie(cookie);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Cookie[] cookies = request.getCookies();
        String ifName = "";
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("remember")){
                ifName = cookie.getValue();
            }
        }
        if(ifName.equals("")) {
            response.getWriter().append("<form action=\"/rememberMe\" method=\"post\">\n" +
                    "    Name:<input type=\"text\" name=\"name\">\n" +
                    "    <input type=\"checkbox\" name=\"remember\" value=\"remember\">\n" +
                    "    <input type=\"submit\" value=\"Zapamiętaj\">\n" +
                    "</form>");
        } else {
            response.getWriter().append("Cześć " + ifName + ". Twoje dane zostały wczytane z ciasteczka");
        }
    }
}
