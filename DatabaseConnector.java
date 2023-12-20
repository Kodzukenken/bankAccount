import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static String URL = "jdbc:mysql://localhost";
    private static String PORT = ":3306";
    private static String DATABASE = "/mvc_tutorial"; //your database name
    private static String USERNAME = "root";
    private static String PASSWORD = " ";

    public static Connection connect() throws SQLException{
        try {
            return DriverManager.getConnection(URL+PORT+DATABASE, USERNAME, PASSWORD);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}