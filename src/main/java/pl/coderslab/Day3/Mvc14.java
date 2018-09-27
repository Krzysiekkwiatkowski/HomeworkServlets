package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Mvc14")
public class Mvc14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book(request.getParameter("title1"), request.getParameter("author1"), request.getParameter("isbn1"));
        Book book2 = new Book(request.getParameter("title2"), request.getParameter("author2"), request.getParameter("isbn2"));
        Book book3 = new Book(request.getParameter("title3"), request.getParameter("author3"), request.getParameter("isbn3"));
        Book book4 = new Book(request.getParameter("title4"), request.getParameter("author4"), request.getParameter("isbn4"));
        Book book5 = new Book(request.getParameter("title5"), request.getParameter("author5"), request.getParameter("isbn5"));
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/result_2.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form.jsp")
                .forward(request, response);
    }
}
