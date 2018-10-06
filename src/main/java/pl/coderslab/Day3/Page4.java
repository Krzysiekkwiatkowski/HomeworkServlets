package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/history")
public class Page4 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        if(request.getParameter("del") == null) {
            ArrayList<Integer> pages;
            HttpSession session = request.getSession();
            Object pagesObject = session.getAttribute("pages");
            if (pagesObject == null) {
                pages = new ArrayList<>();
                pages.add(4);
                session.setAttribute("pages", pages);
            } else {
                pages = (ArrayList<Integer>) pagesObject;
                pages.add(4);
                session.setAttribute("pages", pages);
            }
            response.getWriter().append("Witaj na stronie 4</br>");
            response.getWriter().append("<a href=\"http://localhost:8080/history?del=true\"> Usuń historię </a></br>");
            response.getWriter().append("Odwiedzałeś:</br>");
            for (Integer number : pages) {
                response.getWriter().append("Strona " + number + "</br>");
            }
        } else {
            HttpSession session = request.getSession();
            session.removeAttribute("pages");
        }
    }
}
