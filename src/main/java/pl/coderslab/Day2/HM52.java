package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet("/HM52")
public class HM52 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String[] products;
        int[] quantities;
        double[] prices;
        double sum = 0.0;
        HttpSession session = request.getSession();
        Object basketObject = session.getAttribute("basket");
        if(basketObject == null){
            response.getWriter().append("Brak produktów w koszyku");
        } else {
            String[] basket = (String[]) basketObject;
            for (int i = 0; i < basket.length; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(basket[i],"+");
                products = new String[i + 1];
                quantities = new int[i + 1];
                prices = new double[i + 1];
                while (stringTokenizer.hasMoreTokens()){
                    products[i] = stringTokenizer.nextToken();
                    quantities[i] = Integer.parseInt(stringTokenizer.nextToken());
                    prices[i] = Double.parseDouble(stringTokenizer.nextToken());
                }
                double result = quantities[i] * prices[i];
                sum += result;
                response.getWriter().append(products[i] + " - " + quantities[i] + " x " + prices[i] + "zł = " + result + "zł" + "</br>");
            }
            response.getWriter().append("SUMA: " + sum + "zł");
        }
    }
}
