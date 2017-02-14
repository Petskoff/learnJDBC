package pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "root";
    private final String PASSOWRD = "root";

    private Connection connection;
    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSOWRD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
