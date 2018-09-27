package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Mvc153")
public class Mvc153 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> books;
        HttpSession session = request.getSession();
        Object booksObject = session.getAttribute("books");
        if(booksObject != null){
            System.out.println("gfdgf");
            books = (ArrayList<Book>) booksObject;
            request.setAttribute("books", books);
            getServletContext().getRequestDispatcher("/result_3.jsp")
                    .forward(request, response);
        } else {
            String noBooks = "There are no books";
            request.setAttribute("empty", noBooks);
            getServletContext().getRequestDispatcher("/result_3.jsp")
                    .forward(request, response);
        }

    }
}
