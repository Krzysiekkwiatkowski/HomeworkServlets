package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/newsletter")
public class HM8 extends HttpServlet {

    private static final String ADD_QUERY = "INSERT INTO guests(email, name) VALUES (?,?)";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guests?useSSL=false&useUnicode=yes&characterEncoding=UTF-8", "root", "coderslab");
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        String value = "Page_visited";
        Cookie cookie = new Cookie("newsletter", value);
        cookie.setMaxAge(86400);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean exists = false;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");
        response.getWriter().append("</br></br>");
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("newsletter")){
                exists = true;
            }
        }
        if(!exists) {
            response.getWriter().append("<form action=\"/newsletter\" method=\"post\">\n" +
                    "    Email: <input type=\"text\" name=\"email\">\n" +
                    "    Imię i nazwisko: <input type=\"text\" name=\"name\">\n" +
                    "    <input type=\"submit\" value=\"Zapisz\">\n" +
                    "</form>");
            exists = false;
        }
    }
}
