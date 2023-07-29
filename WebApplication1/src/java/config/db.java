package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    public static Connection getConnection() throws ClassNotFoundException {
        
        String username = "sa";
        String password = "01tranduc";
        String connectionUrl = "jdbc:sqlserver://localhost:1434;databaseName=db;user="+username+";password="+password+";encrypt=false;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = null;

        try {
//            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;user=MyUserName;password=*****;encrypt=false;";  
            connection = DriverManager.getConnection(connectionUrl);  
            System.out.println("Connected to SQL Server.");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }

        return connection;
    }
}
