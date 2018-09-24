package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie6", urlPatterns = "/Cookie6")
public class Cookie6 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");
        String background = request.getParameter("background");
        String textValue = "";
        String backgroundValue = "";
        if (!text.equals("") && !background.equals("")) {
            Cookie cookie1 = new Cookie("text", text);
            Cookie cookie2 = new Cookie("background", background);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.getWriter().append("<div style=\"color: " + text + "; background-color: " + background + "\"> Wybrałeś kolor tekstu jako:" + text + ", oraz tła jako:" + background + ". Twoje wybory zostały zapisane w ciasteczku. </div>");
        } else if (text.equals("") && background.equals("")) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("text")) {
                    textValue = cookie.getValue();
                }
                if (cookie.getName().equals("background")) {
                    backgroundValue = cookie.getValue();
                }
            }
            if (!textValue.equals("") && !backgroundValue.equals("")) {
                response.getWriter().append("Zapamiętany w ciasteczku kolor tekstu to: " + textValue + ", oraz tła jako: " + backgroundValue+ ".");
            } else {
                response.sendRedirect("/index_6.html");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index_6.html");
    }
}
