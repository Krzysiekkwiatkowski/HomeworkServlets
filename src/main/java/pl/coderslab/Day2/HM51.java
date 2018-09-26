package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/HM51")
public class HM51 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String[] basket;
        String product = request.getParameter("product");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String item = product + "+" + quantity + "+" + price;
        HttpSession session = request.getSession();
        Object basketObject = session.getAttribute("basket");
        if (basketObject == null) {
            basket = new String[1];
            basket[0] = item;
        } else {
            basket = (String[]) basketObject;
            String[] actualBasket = new String[basket.length + 1];
            for (int i = 0; i < basket.length; i++) {
                actualBasket[i] = basket[i];
            }
            actualBasket[basket.length] = item;
            basket = actualBasket;
        }
        session.setAttribute("basket", basket);
        response.getWriter().append("<form action=\"/HM51\" method=\"post\">\n" +
                "    Product: <input type=\"text\" name=\"product\">\n" +
                "    Quantity: <input type=\"number\" min=\"1\" name=\"quantity\">\n" +
                "    Price: <input type=\"number\" min=\"0.01\" step=\"0.01\" name=\"price\">\n" +
                "    <input type=\"submit\" value=\"Dodaj\">\n" +
                "</form> ");
        response.getWriter().append("<a href=\"http://localhost:8080/HM52\"> Pokaż koszyk </a>");
        response.getWriter().append("Produkt dodany");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("<form action=\"/HM51\" method=\"post\">\n" +
                "    Product: <input type=\"text\" name=\"product\">\n" +
                "    Quantity: <input type=\"number\" min=\"1\" name=\"quantity\">\n" +
                "    Price: <input type=\"number\" min=\"0.01\" step=\"0.01\" name=\"price\">\n" +
                "    <input type=\"submit\" value=\"Dodaj\">\n" +
                "</form> ");
        response.getWriter().append("<a href=\"http://localhost:8080/HM52\"> Pokaż koszyk </a>");
    }
}

