Create table guests = "CREATE TABLE guests(id INT AUTO_INCREMENT, email VARCHAR(100), name VARCHAR(100), PRIMARY KEY(id));
";
Create table news = "CREATE TABLE news(id INT AUTO_INCREMENT, title VARCHAR(50), description TEXT, PRIMARY KEY(id));
";
private static final String SHOW_ALL_QUERY = "SELECT * FROM guests";
private static final String ADD_QUERY = "INSERT INTO guests(email, name) VALUES (?,?)";
private static final String ADD_QUERY = "INSERT INTO news(title, description) VALUES (?,?)";