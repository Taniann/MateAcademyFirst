package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.sql.*;
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
        showMetaData(rs);

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
        CRUDTemplate<Order> crudTemplate = (ord, connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO orders(order_Num, order_Date, mfr, qty, amount ) VALUES (?,?,?,?,?) ");

            preparedStatement.setBigDecimal(1, order.getOrderNum());
            preparedStatement.setDate(2, Date.valueOf(order.getOrderDate()));
            preparedStatement.setString(3, order.getMfr());
            preparedStatement.setBigDecimal(4, order.getQty());
            preparedStatement.setBigDecimal(5, order.getAmount());
            return preparedStatement;
        };
        return crudTemplate.templateOperation(order);
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        CRUDTemplate<Order> crudTemplate = (ord, connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE orders SET amount = ? WHERE order_Num = ? ");
            preparedStatement.setBigDecimal(1, order.getAmount());
            preparedStatement.setBigDecimal(2, order.getOrderNum());
            return preparedStatement;
        };
        return crudTemplate.templateOperation(order);
    }

    @Override
    public boolean deleteOrder(Order order) throws SQLException {
        CRUDTemplate<Order> crudTemplate = (ord, connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE order_Num = ?");

            preparedStatement.setBigDecimal(1, order.getOrderNum());
            return preparedStatement;
        };
        return crudTemplate.templateOperation(order);
    }

    public void showMetaData(ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        Integer countRow = resultSetMetaData.getColumnCount();

        for (int i = 1; i <= countRow; i++) {
            System.out.println("column name " + resultSetMetaData.getColumnName(i));
            System.out.println("column class name " + resultSetMetaData.getColumnClassName(i));
            System.out.println("column type " + resultSetMetaData.getColumnType(i));
            System.out.println("column type name " + resultSetMetaData.getColumnTypeName(i));
            System.out.println("table name " + resultSetMetaData.getTableName(i));
        }
    }
}
