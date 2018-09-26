package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/HM3")
public class HM3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String input1 = request.getParameter("input1");
        String input2 = request.getParameter("input2");
        String input3 = request.getParameter("input3");
        String input4 = request.getParameter("input4");
        String input5 = request.getParameter("input5");
        HttpSession session = request.getSession();
        session.setAttribute("input1", input1);
        session.setAttribute("input2", input2);
        session.setAttribute("input3", input3);
        session.setAttribute("input4", input4);
        session.setAttribute("input5", input5);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Object input1Object = session.getAttribute("input1");
        Object input2Object = session.getAttribute("input2");
        Object input3Object = session.getAttribute("input3");
        Object input4Object = session.getAttribute("input4");
        Object input5Object = session.getAttribute("input5");
        response.getWriter().append("<form action=\"/HM3\" method=\"post\">\n");
        if(session.getAttribute("input1") != null){
            response.getWriter().append("    Input 1:<input type=\"text\" name=\"input1\" value=\"" + (String)input1Object + "\"></br>\n");
        } else {
            response.getWriter().append("    Input 1:<input type=\"text\" name=\"input1\"></br>\n");
        }
        if(session.getAttribute("input1") != null){
            response.getWriter().append("    Input 2:<input type=\"text\" name=\"input2\" value=\"" + (String)input2Object + "\"></br>\n");
        } else {
            response.getWriter().append("    Input 2:<input type=\"text\" name=\"input2\"></br>\n");
        }
        if(session.getAttribute("input1") != null){
            response.getWriter().append("    Input 3:<input type=\"text\" name=\"input3\" value=\"" + (String)input3Object + "\"></br>\n");
        } else {
            response.getWriter().append("    Input 3:<input type=\"text\" name=\"input3\"></br>\n");
        }
        if(session.getAttribute("input1") != null){
            response.getWriter().append("    Input 4:<input type=\"text\" name=\"input4\" value=\"" + (String)input4Object + "\"></br>\n");
        } else {
            response.getWriter().append("    Input 4:<input type=\"text\" name=\"input4\"></br>\n");
        }
        if(session.getAttribute("input1") != null){
            response.getWriter().append("    Input 5:<input type=\"text\" name=\"input5\" value=\"" + (String)input5Object + "\"></br>\n");
        } else {
            response.getWriter().append("    Input 5:<input type=\"text\" name=\"input5\"></br>\n");
        }
         response.getWriter().append("    <input type=\"submit\" value=\"Wyślij\">\n" +
                "</form>");
    }
}
