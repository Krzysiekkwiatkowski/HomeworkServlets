package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search-book")
public class MvcJdbc05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String find = request.getParameter("titlePart");
        String titlePart = "%" + find + "%";
        List<Book> books = BookDao.find(titlePart);
        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/Jdbc4.jsp")
                .forward(request, response);

    }
}
