package pl.coderslab.Day3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
//    private String CREATE_TABLE_BOOKS = "CREATE TABLE books(id INT AUTO_INCREMENT, title VARCHAR(100) NOT NULL, author VARCHAR(100) NOT NULL, isbn VARCHAR(100) NOT NULL, PRIMARY KEY(id))";

    private static String ADD_BOOK = "INSERT INTO books(title, author, isbn) VALUES (?, ?, ?)";
    private static String DELETE_BOOK = "DELETE FROM books WHERE id=?";
    private static String GET_ALL_BOOKS = "SELECT * FROM books";
    private static String LOAD_BOOK = "SELECT * FROM books WHERE id= ?";
    private static String EDIT_BOOK = "UPDATE books SET title = ? , author = ?, isbn = ? WHERE id = ?";
    private static String FIND_BOOK = "SELECT * FROM books WHERE title LIKE ?";

    public static Book save(Book book){
        try {
            Connection connection = DBUtil.getConnection();
            if (book.getId() == 0){
                String[] generatedColumns = {"ID"};
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOOK, generatedColumns);
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getAuthor());
                preparedStatement.setString(3, book.getIsbn());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.isFirst()) {
                    book.setId(resultSet.getInt(1));
                }
                return book;
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement(EDIT_BOOK);
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getAuthor());
                preparedStatement.setString(3, book.getIsbn());
                preparedStatement.setInt(4, book.getId());
                preparedStatement.executeUpdate();
            }
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

    public static List<Book> getAll(){
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String isbn= resultSet.getString("isbn");
                Book book = new Book(title, author, isbn);
                book.setId(id);
                books.add(book);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }

    public static Book load(int id){
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(LOAD_BOOK);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Book book = new Book();
            while (resultSet.next()){
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
            }
            return book;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Book> find(String titlePart){
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BOOK);
            preparedStatement.setString(1, titlePart);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setId(resultSet.getInt("id"));
                books.add(book);
            }
            return books;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
