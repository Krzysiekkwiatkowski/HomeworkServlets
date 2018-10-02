package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hm2")
public class HM2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        request.setAttribute("numbers", numbers);
        getServletContext().getRequestDispatcher("/HM2.jsp")
                .forward(request, response);
    }
}
