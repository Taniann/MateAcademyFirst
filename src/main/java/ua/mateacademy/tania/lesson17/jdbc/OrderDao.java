package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
public interface OrderDao {
    Set<Order> getAllOrders() throws SQLException;

    Set<Order> getAllOrdersWithJoinQuery() throws SQLException;

    Order findOrderById(BigDecimal id) throws SQLException;

    boolean insertOrder(Order order) throws SQLException;

    boolean updateOrder(Order order) throws SQLException;

    boolean deleteOrder(BigDecimal id) throws SQLException;
}
