package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-book")
public class MvcJdbc04 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Book book = BookDao.load(Integer.parseInt(request.getParameter("id")));
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setIsbn(request.getParameter("isbn"));
        BookDao.save(book);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = BookDao.load(id);
        request.setAttribute("book", book);
        getServletContext().getRequestDispatcher("/Jdbc3.jsp")
                .forward(request, response);
    }
}
