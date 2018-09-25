package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addToSession")
public class Sess03_Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        HttpSession session = request.getSession();
        String[] keys = (String[]) session.getAttribute("keys");
        String[] newKeys;
        if (keys != null) {
            newKeys = new String[keys.length + 1];
            for (int i = 0; i < keys.length; i++) {
                newKeys[i] = keys[i];
            }
            newKeys[keys.length] = key;
            session.setAttribute("keys", newKeys);
            session.setAttribute(key, value);
        } else {
            newKeys = new String[1];
            newKeys[0] = key;
            session.setAttribute("keys", newKeys);
            session.setAttribute(key, value);
        }
        response.sendRedirect("/addToSession");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("<form action=\"/addToSession\" method=\"POST\">\n" +
                "    <label>\n" +
                "        Klucz:\n" +
                "        <input type=\"text\" name=\"key\">\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Wartość:\n" +
                "        <input type=\"text\" name=\"value\">\n" +
                "    </label>\n" +
                "    <input type=\"submit\">\n" +
                "</form>");
    }
}
