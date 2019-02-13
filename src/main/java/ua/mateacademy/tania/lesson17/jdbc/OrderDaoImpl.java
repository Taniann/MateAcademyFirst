package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
public class OrderDaoImpl implements OrderDao{

    @Override
    public Set<Order> getAllOrders() throws SQLException {
        return null;
    }

    @Override
    public Order findOrderById(BigDecimal id) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT* FROM orders WHERE order_num=?");
        preparedStatement.setBigDecimal(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        Order order = null;
        if (rs.next()) {
            order = new Order(rs.getBigDecimal("order_Num"), null, rs.getDate("order_Date").toLocalDate(), rs.getString("mfr"),
                    rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));

        }

        rs.close();
        preparedStatement.close();
        connection.close();
        return order;
    }

    @Override
    public boolean insertOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOrder(BigDecimal id) throws SQLException {
        return false;
    }
}
