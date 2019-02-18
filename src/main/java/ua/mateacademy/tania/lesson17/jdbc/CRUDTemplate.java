package ua.mateacademy.tania.lesson17.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface  CRUDTemplate<T> {
     default boolean templateOperation(T t) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Boolean isDone;

        try {
            connection = ConnectionDB.getConnection();
            preparedStatement = returnPreparedStatement(t, connection);
            isDone = preparedStatement.executeUpdate() > 0;
        } finally {
            connection.close();
            preparedStatement.close();
        }
        return isDone;
    }

     PreparedStatement returnPreparedStatement(T t, Connection connection) throws SQLException;
}
