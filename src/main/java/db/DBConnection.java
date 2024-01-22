package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getInstance() {
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/practice";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("db connect success");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
