package pro;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by PRO on 13.02.2017.
 */
public class main {
//    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
//    private static final String USERNAME = "root";
//    private static final String PASSOWRD = "root";

    private static final String NEWROW = "INSERT INTO users (username,password,icon) VALUES (?,?,?)";

    public static void main(String[] args) throws SQLException {
        DBWorker worker = new DBWorker();
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        String query = "select * from users;";

        try {
            preparedStatement = worker.getConnection().prepareStatement(NEWROW);

            preparedStatement.setString(1,"Kabaska");
            preparedStatement.setString(2,"Bean");
            preparedStatement.setBlob(3, new FileInputStream("icon.jpg"));
            preparedStatement.execute();

            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString(3));
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            preparedStatement.close();
            statement.close();
        }

    }
}
