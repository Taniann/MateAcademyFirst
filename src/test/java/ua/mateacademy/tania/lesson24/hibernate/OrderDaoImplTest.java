package ua.mateacademy.tania.lesson24.hibernate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ua.mateacademy.tania.lesson22.Customer;
import ua.mateacademy.tania.lesson22.Order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Tania Nebesna on 28.02.2019
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplTest {
    private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(111);
    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112922);
    private static final Customer CUSTOMER = new Customer(BigDecimal.valueOf(2111));
    private static final Order ORDER = new Order(BigDecimal.valueOf(11111111), CUSTOMER, null, null, new Date(),
                                            "mfr", BigDecimal.valueOf(1000), BigDecimal.valueOf(1000));
    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void testGetAllOrder() {
        Set<Order> orders = orderDao.getAllOrder();
        System.out.println(orders);
        System.out.println(orders.size());
        assertTrue(orders.size() > 25);
    }

    @Test
    public void testFindOrderById() {
        Order order = orderDao.findOrderById(ALREADY_EXIST_ORDER);
        assertNotNull(order);
    }

    @Test
    public void testFindOrderByIdReturnsNull() {
        Order order = orderDao.findOrderById(NOT_EXIST_ORDER);
        assertNull(order);
    }

    @Test
    public void test1InsertOrder() {
        assertTrue(orderDao.insertOrder(ORDER));
    }

    @Test
    public void test2UpdateOrder() {
        ORDER.setAmount(new BigDecimal(1220));
        assertTrue(orderDao.updateOrder(ORDER));
    }

    @Test
    public void test3Delete3Order() {
        assertTrue(orderDao.deleteOrder(ORDER.getOrderNum()));
    }
}