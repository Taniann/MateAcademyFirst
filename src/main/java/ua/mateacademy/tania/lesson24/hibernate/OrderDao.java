package ua.mateacademy.tania.lesson24.hibernate;

import ua.mateacademy.tania.lesson22.Order;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Tania Nebesna on 28.02.2019
 */
public interface OrderDao {
    Set<Order> getAllOrder();

    Order findOrderById(BigDecimal id);

    boolean insertOrder(Order order);

    boolean updateOrder(Order order);

    boolean deleteOrder(BigDecimal id);
}
