package ua.mateacademy.tania.lesson17.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Tania Nebesna on 14.02.2019.
 */
public class ConnectionDB {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "MA_STUDENT";
    public static final String PASS = "KOLOBOK";

    private static ComboPooledDataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(URL);
        cpds.setUser(USER);
        cpds.setPassword(PASS);

        // Optional Settings
        cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);

        return cpds;
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Locale.setDefault(Locale.ENGLISH);
            ComboPooledDataSource dataSource = getDataSource();
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
