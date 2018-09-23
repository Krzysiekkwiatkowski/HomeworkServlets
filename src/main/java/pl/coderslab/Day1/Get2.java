package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get2", urlPatterns = "/Get2")
public class Get2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String[] values = request.getParameterValues("param");
        try {
            for (String value : values) {
                response.getWriter().append(value + "   ");
            }
        } catch (NullPointerException e){
            response.getWriter().append("Brak przekazanych parametrów do wyświetlenia");
        }
    }
}
