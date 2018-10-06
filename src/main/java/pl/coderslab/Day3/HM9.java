package pl.coderslab.Day3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/guest-book")
public class HM9 extends HttpServlet {

    private static final String SHOW_ALL_QUERY = "SELECT * FROM guests";
    private static final String ADD_QUERY = "INSERT INTO news(title, description) VALUES (?,?)";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String user = getServletContext().getInitParameter("user");
            String password = getServletContext().getInitParameter("password");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guests?useSSL=false&useUnicode=yes&characterEncoding=UTF-8", user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("<form action=\"/guest-book\" method=\"post\">\n" +
                "    Tytuł: <input type=\"text\" name=\"title\">\n" +
                "    Treść: <input type=\"text\" name=\"description\">\n" +
                "    <input type=\"submit\" value=\"Zapisz\">\n" +
                "</form>");
        try {
            ArrayList<Guest> guests = new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String user = getServletContext().getInitParameter("user");
            String password = getServletContext().getInitParameter("password");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guests?useSSL=false&useUnicode=yes&characterEncoding=UTF-8", user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                Guest guest = new Guest(email, name);
                guests.add(0, guest);
            }
            for (Guest guest : guests){
            response.getWriter().append(guest.getEmail() + " - " + guest.getName() + "</br>");
        }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
