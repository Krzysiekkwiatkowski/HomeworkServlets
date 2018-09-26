package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HM6")
public class HM6 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String[] nums = request.getParameterValues("num");
        if(nums == null){
            response.sendRedirect("/HM6.html");
        } else {
            response.getWriter().append("Liczby:" + "</br>");
            for (String num : nums) {
                response.getWriter().append(" - " + num + "</br>");
            }
            response.getWriter().append("Średnia:" + "</br>");
            double avg = (Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]) + Integer.parseInt(nums[2]) + Integer.parseInt(nums[3])) / 4.0;
            response.getWriter().append(" - " + avg + "</br>");
            response.getWriter().append("Suma:" + "</br>");
            int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]) + Integer.parseInt(nums[2]) + Integer.parseInt(nums[3]);
            response.getWriter().append(" - " + sum + "</br>");
            response.getWriter().append("Iloczyn:" + "</br>");
            int multiplied = Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]) * Integer.parseInt(nums[2]) * Integer.parseInt(nums[3]);
            response.getWriter().append(" - " + multiplied + "</br>");
        }
    }
}
