package ua.mateacademy.tania.lesson17.jdbc;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
public class OrderDaoImplTest {
    private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(111);
    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112922);
    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void testFindOrderById() throws SQLException {
        Order order = orderDao.findOrderById(ALREADY_EXIST_ORDER);
        assertNotNull(order);
    }

    @Test
    public void testFindOrderByIdNotPresent() throws SQLException {
        Order order = orderDao.findOrderById(NOT_EXIST_ORDER);
        assertNull(order);
    }
}