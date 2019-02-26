package ua.mateacademy.tania.lesson22;


import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
public interface OrderDao {
    Set<Order> getAllOrders();

    Order findOrderById(BigDecimal id);

    boolean insertOrder(Order order);

    boolean updateOrder(Order order);

    boolean deleteOrder(BigDecimal id);
}
