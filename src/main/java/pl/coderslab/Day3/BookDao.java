package pl.coderslab.Day3;

import java.sql.*;

public class BookDao {
//    private String CREATE_TABLE_BOOKS = "CREATE TABLE books(id INT AUTO_INCREMENT, title VARCHAR(100) NOT NULL, author VARCHAR(100) NOT NULL, isbn VARCHAR(100) NOT NULL, PRIMARY KEY(id))";

    private static String ADD_BOOK = "INSERT INTO books(title, author, isbn) VALUES (?, ?, ?)";
    private static String DELETE_BOOK = "DELETE FROM books WHERE id=?";

    public static Book save(Book book){
        try{
            Connection connection = DBUtil.getConnection();
            String[] generatedColumns = {"ID"};
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOOK, generatedColumns);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getIsbn());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.isFirst()){
                book.setId(resultSet.getInt(1));
            }
            return book;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void delete(int id){
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
