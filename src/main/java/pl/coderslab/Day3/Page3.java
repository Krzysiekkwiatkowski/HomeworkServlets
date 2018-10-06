package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Page3")
public class Page3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        ArrayList<Integer> pages;
        HttpSession session = request.getSession();
        Object pagesObject = session.getAttribute("pages");
        if(pagesObject == null){
            pages = new ArrayList<>();
            pages.add(3);
            session.setAttribute("pages", pages);
        } else {
            pages = (ArrayList<Integer>) pagesObject;
            pages.add(3);
            session.setAttribute("pages", pages);
        }
        response.getWriter().append("Witaj na stronie 3</br>");
        response.getWriter().append("<a href=\"http://localhost:8080/Page1\"> Strona 1 </a></br>");
        response.getWriter().append("<a href=\"http://localhost:8080/Page2\"> Strona 2 </a></br>");
        response.getWriter().append("<a href=\"http://localhost:8080/history\"> Strona 4 </a></br>");
        response.getWriter().append("<a href=\"http://localhost:8080/Page5\"> Strona 5 </a></br>");
    }
}
