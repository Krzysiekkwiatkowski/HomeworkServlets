package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Mvc151")
public class Mvc151 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> books;
        HttpSession session = request.getSession();
        Book book = new Book(request.getParameter("title"), request.getParameter("author"), request.getParameter("isbn"));
        Object booksObject = session.getAttribute("books");
        if(booksObject == null){
            books = new ArrayList<>();
            books.add(book);
            session.setAttribute("books", books);
        } else {
            books = (ArrayList<Book>) booksObject;
            books.add(book);
        }
        session.setAttribute("books", books);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form_1.jsp")
                .forward(request, response);
    }
}
