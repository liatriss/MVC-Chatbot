import java.sql.*;

public class Connectdb {
    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/dbmysql";
            Connection con = DriverManager.getConnection(url, "root", "");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }    
}
