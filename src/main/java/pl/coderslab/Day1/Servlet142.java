package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet(name = "Servlet142", urlPatterns = "/Servlet042")
public class Servlet142 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String products[] = {
                "Asus Transformr;2999.99",
                "iPhone 6';3499.18",
                "Converse Sneakers;125.00",
                "LG OLED55B6P OLED TV;6493.91"
        };
        int id = Integer.parseInt(request.getParameter("id"));
        if(id >= 0 && id < products.length) {
            StringTokenizer stringTokenizer = new StringTokenizer(products[id],";");
            String name = "";
            double price = 0.0;
            name = stringTokenizer.nextToken();
            price = Double.parseDouble(stringTokenizer.nextToken());
            response.getWriter().append(name + " - " + price + "zł");
        } else {
            response.getWriter().append("Product not found.");
        }
    }
}
