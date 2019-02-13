package ua.mateacademy.tania.lesson17.jdbc;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
public class ConnectionDB {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "MA_STUDENT";
    public static final String PASS = "KOLOBOK";


    public static Connection getConnection() {
        Connection connection = null;

        try {
            Locale.setDefault(Locale.ENGLISH);
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
