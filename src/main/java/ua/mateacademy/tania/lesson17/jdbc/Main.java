package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        OrderDao orderDao = new OrderDaoImpl();
        Order order = null;

        order = orderDao.findOrderById(BigDecimal.valueOf(112922));
        System.out.println(order);

        Set<Order> orderSet = orderDao.getAllOrders();
        orderSet.forEach(System.out::println);

    }
}
