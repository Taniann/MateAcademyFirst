package ua.mateacademy.tania.lesson22;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.util.Date;


import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplTest {
    private static final Order ORDER = new Order(BigDecimal.valueOf(121212), null,
            new Date(), "101", BigDecimal.valueOf(121),
            BigDecimal.valueOf(1214));
    private OrderDao orderDao = new OrderDaoImpl();

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
    public void test3DeleteOrder() {
        assertTrue(orderDao.deleteOrder(ORDER.getOrderNum()));
    }
}