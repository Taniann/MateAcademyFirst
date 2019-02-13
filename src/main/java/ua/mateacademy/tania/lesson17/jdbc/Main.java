package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
public class Main {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDaoImpl();
        Order order = null;
        try {
             order = orderDao.findOrderById(BigDecimal.valueOf(112922));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(order);
    }
}
