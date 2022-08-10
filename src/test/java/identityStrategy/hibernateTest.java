package identityStrategy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.sql.*;

public class hibernateTest {

  @Test
  void test() throws SQLException {
    String jdbcURL = "jdbc:h2:mem:test";
    Connection connection = DriverManager.getConnection(jdbcURL);

    System.out.println("Connected to H2 in-memory database.");

    String sql = "Create table students (ID int primary key, name varchar(50))";

    Statement statement = connection.createStatement();

    statement.execute(sql);

    System.out.println("Created table students.");

    sql = "Insert into students (ID, name) values (1, 'Nam Ha Minh')";

    int rows = statement.executeUpdate(sql);

    if (rows > 0) {
      System.out.println("Inserted a new row.");
    }

    sql = "SELECT * FROM students";

    ResultSet resultSet = statement.executeQuery(sql);

    while(resultSet.next()){
      System.out.println(" 아이디 값 : "+resultSet.getInt("ID"));
      System.out.println(" 이름 값 : "+resultSet.getString("name"));
    }


    connection.close();
  }

  @Test
  void test2() throws SQLException {
    String jdbcURL = "jdbc:h2:~/test";
    String username = "sa";

    Connection connection = DriverManager.getConnection(jdbcURL, username, null);
    System.out.println("Connected to H2 embedded database.");

    String sql = "SELECT * FROM students";

    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    int count = 0;

    while (resultSet.next()) {
      count++;

      int ID = resultSet.getInt("ID");
      String name = resultSet.getString("name");
      System.out.println("Student #" + count + ": " + ID + ", " + name);
    }

    connection.close();
  }
}
