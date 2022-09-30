package peaksoft.util;

import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:postgresql://localhost:5431/user";
    private static final String username = "postgres";
    private static final String possword = "1234567891";

    public static Connection connection() {
        Connection conn =null;
        try {
            conn = DriverManager.getConnection(url, username, possword);
            System.out.println("Подключено успешно к базе данных");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public static SessionFactory getSessionFactory() {
        return null;

    }
}
