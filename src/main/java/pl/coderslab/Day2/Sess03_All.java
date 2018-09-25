package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/showAllSession")
public class Sess03_All extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String[] keys = (String[]) session.getAttribute("keys");
        response.getWriter().append("<table border=\"1px solid black\">\n" +
                "    <tr>\n" +
                "        <th> Key </th>\n" +
                "        <th> Value </th>\n" +
                "    </tr>");
        for (String key : keys){
            String value = (String) session.getAttribute(key);
            response.getWriter().append("<tr>\n" +
                    "<td>" + key +"</td>\n" +
                    "    <td> " + value + " </td>\n" +
            "</tr>");
        }
        response.getWriter().append("</table>");
    }
}
