package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Mvc152")
public class Mvc152 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> books;
        HttpSession session = request.getSession();
        Book book1 = new Book(request.getParameter("title1"), request.getParameter("author1"), request.getParameter("isbn1"));
        Book book2 = new Book(request.getParameter("title2"), request.getParameter("author2"), request.getParameter("isbn2"));
        Book book3 = new Book(request.getParameter("title3"), request.getParameter("author3"), request.getParameter("isbn3"));
        Object booksObject = session.getAttribute("books");
        if(booksObject == null){
            books = new ArrayList<>();
            books.add(book1);
            books.add(book2);
            books.add(book3);
            session.setAttribute("books", books);
        } else {
            books = (ArrayList<Book>) booksObject;
            books.add(book1);
            books.add(book2);
            books.add(book3);
        }
        session.setAttribute("books", books);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form_2.jsp")
                .forward(request, response);
    }
}
