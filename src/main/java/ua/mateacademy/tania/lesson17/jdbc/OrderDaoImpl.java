package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tania Nebesna on 12.02.2019.
 */
public class OrderDaoImpl implements OrderDao{


    @Override
    public Set<Order> getAllOrders() throws SQLException {
        Set<Order> orders = new HashSet<>();
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT* FROM orders");
            ResultSet rsOrder = preparedStatement1.executeQuery();
        ) {

            while(rsOrder.next()) {
                BigDecimal orderNum = rsOrder.getBigDecimal("order_Num");
                LocalDate orderDate = rsOrder.getDate("order_Date").toLocalDate();
                String mfr = rsOrder.getString("mfr");
                BigDecimal qty = rsOrder.getBigDecimal("qty");
                BigDecimal amount = rsOrder.getBigDecimal("amount");

                PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT* FROM products WHERE product_id = ?");
                preparedStatement2.setString(1,rsOrder.getString("product"));
                ResultSet rsProduct = preparedStatement2.executeQuery();

                Product product = null;

                if(rsProduct.next()) {
                    product = new Product(rsProduct.getString("product_Id"), rsProduct.getString("mfr_Id"),
                            rsProduct.getString("description"), rsProduct.getBigDecimal("price"),
                            rsProduct.getBigDecimal("qty_On_Hand"));
                }

                Order order = new Order(orderNum, product, orderDate, mfr, qty, amount);
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public Set<Order> getAllOrdersWithJoinQuery() throws SQLException {
        Set<Order> orders = new HashSet<>();
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement
                    ("SELECT* FROM orders JOIN products ON product = product_id");
            ResultSet rs = preparedStatement1.executeQuery()
        ) {
            while(rs.next()) {
                BigDecimal orderNum = rs.getBigDecimal("order_Num");
                LocalDate orderDate = rs.getDate("order_Date").toLocalDate();
                String mfr = rs.getString("mfr");
                BigDecimal qty = rs.getBigDecimal("qty");
                BigDecimal amount = rs.getBigDecimal("amount");
                Product product = new Product(rs.getString("product_Id"), rs.getString("mfr_Id"),
                        rs.getString("description"), rs.getBigDecimal("price"),
                        rs.getBigDecimal("qty_On_Hand"));

                Order order = new Order(orderNum, product, orderDate, mfr, qty, amount);
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public Order findOrderById(BigDecimal id) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT* FROM orders WHERE order_num=?");
        preparedStatement.setBigDecimal(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        Order order = null;
        if (rs.next()) {
            order = new Order(rs.getBigDecimal("order_Num"), null, rs.getDate("order_Date").toLocalDate(), rs.getString("mfr"),
                    rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));

        }

        rs.close();
        preparedStatement.close();
        connection.close();
        return order;
    }

    @Override
    public boolean insertOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOrder(BigDecimal id) throws SQLException {
        return false;
    }
}
