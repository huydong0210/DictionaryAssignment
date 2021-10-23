import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sql {
    private static Connection conn;
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:./database\\dict_hh.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return conn;
    }
}
