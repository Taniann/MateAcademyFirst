package ua.mateacademy.tania.lesson24.hibernate;

import org.junit.Test;
import ua.mateacademy.tania.lesson22.Order;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Tania Nebesna on 28.02.2019
 */
public class OrderDaoImplTest {
    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void getAllOrder() {
        System.out.println(orderDao.getAllOrder());
    }

    @Test
    public void findOrderById() {
        Order order = orderDao.findOrderById(BigDecimal.valueOf(112961));
        System.out.println(order);
        assertNotNull(order);
    }

    @Test
    public void insertOrder() {
    }

    @Test
    public void updateOrder() {
    }

    @Test
    public void deleteOrder() {
    }
}