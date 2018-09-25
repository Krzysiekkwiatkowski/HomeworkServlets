package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Sess04")
public class Sess04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String product = request.getParameter("product");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        HttpSession session = request.getSession();
        String[] products = (String[]) session.getAttribute("products");
        int[] quantitys = (int[]) session.getAttribute("quantitys");
        double[] prices = (double[]) session.getAttribute("prices");
        if(products != null){
            String[] newProducts = new String[products.length + 1];
            int[] newQuantitys = new int[quantitys.length + 1];
            double[] newPrices = new double[prices.length + 1];
            for (int i = 0; i < products.length; i++){
                newProducts[i] = products[i];
                newQuantitys[i] = quantitys[i];
                newPrices[i] = prices[i];
            }
            newProducts[products.length] = product;
            newQuantitys[quantitys.length] = quantity;
            newPrices[prices.length] = price;
            products = newProducts;
            quantitys = newQuantitys;
            prices = newPrices;
            session.setAttribute("products", products);
            session.setAttribute("quantitys", quantitys);
            session.setAttribute("prices", prices);
        } else {
            products = new String[1];
            quantitys = new int[1];
            prices = new double[1];
            products[0] = product;
            quantitys[0] = quantity;
            prices[0] = price;
            session.setAttribute("products", products);
            session.setAttribute("quantitys", quantitys);
            session.setAttribute("prices", prices);
        }
        double sum;
        double totalSum = 0.0;
        if(products != null) {
            for (int i = 0; i < products.length; i++) {
                sum = quantitys[i] * prices[i];
                totalSum += sum;
                response.getWriter().append(products[i] + " - " + quantitys[i] + " x " + prices[i] + "zł = " + sum + "zł" + "</br>");
            }
            response.getWriter().append("SUMA: " + totalSum + "zł");
        } else {
            response.getWriter().append("Brak produktów w koszyku");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String[] products = (String[]) session.getAttribute("products");
        int[] quantitys = (int[]) session.getAttribute("quantitys");
        double[] prices = (double[]) session.getAttribute("prices");
        double sum;
        double totalSum = 0.0;
        response.getWriter().append("<form action=\"/Sess04\" method=\"post\">\n" +
                "    Nazwa: <input type=\"text\" name=\"product\">\n" +
                "    Ilość: <input type=\"number\" name=\"quantity\">\n" +
                "    Cena: <input type=\"number\" min=\"0.00\" step=\"0.01\" name=\"price\">\n" +
                "    <input type=\"submit\" value=\"Dodaj\">\n" +
                "</form>");
        if(products != null) {
            for (int i = 0; i < products.length; i++) {
                sum = quantitys[i] * prices[i];
                totalSum += sum;
                response.getWriter().append(products[i] + " - " + quantitys[i] + " x " + prices[i] + "zł = " + sum + "zł" + "</br>");
            }
            response.getWriter().append("SUMA: " + totalSum + "zł");
        } else {
            response.getWriter().append("Brak produktów w koszyku");
        }
    }
}
