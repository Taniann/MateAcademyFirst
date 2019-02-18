package ua.mateacademy.tania.lesson17.jdbc;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplTest {
    private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(111);
    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112922);
    private static final Order order = new Order(BigDecimal.valueOf(121212), null,
            LocalDate.of(2019, Month.JANUARY, 27), "101", BigDecimal.valueOf(121),
            BigDecimal.valueOf(1214));
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

    @Test
    public void testGetAllOrders() throws SQLException {
        Set<Order> orders = orderDao.getAllOrders();
        System.out.println(orders);
        System.out.println(orders.size());
        assertTrue(orders.size() > 25);
    }

    @Test
    public void testGetAllOrdersWithJoinQuery() throws SQLException {
        Set<Order> orders = orderDao.getAllOrdersWithJoinQuery();
        System.out.println(orders);
        System.out.println(orders.size());
        assertTrue(orders.size() > 25);
    }

    @Test
    public void test1InsertOrder() throws SQLException {
        orderDao.insertOrder(order);
        Set<Order> orders = orderDao.getAllOrders();
        assertTrue(orders.contains(order));
    }

    @Test
    public void test2UpdateOrder() throws SQLException {
        order.setAmount(BigDecimal.valueOf(1214));
        orderDao.updateOrder(order);
        Set<Order> orders = orderDao.getAllOrders();
        assertTrue(orders.contains(order));
    }

    @Test
    public void test3DeleteOrder() throws SQLException {
        orderDao.deleteOrder(order);
        Set<Order> orders = orderDao.getAllOrders();
        assertFalse(orders.contains(order));
    }
}