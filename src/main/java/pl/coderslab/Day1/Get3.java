package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Get3", urlPatterns = "/Get3")
public class Get3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int width = 5;
            int height = 10;
            String widthValue = request.getParameter("width");
            String heightValue = request.getParameter("height");
            if(widthValue != null) {
                width = Integer.parseInt(widthValue);
            }
            if(heightValue != null) {
                height = Integer.parseInt(heightValue);
            }
            for (int i = 1; i < height + 1; i++) {
                for (int j = 1; j < width +1; j++) {
                    response.getWriter().append(i + " * " + j + " = " + i*j + "    ");
                }
                response.getWriter().append("\n");
            }
        } catch (NumberFormatException e){
        }
    }
}
