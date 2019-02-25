package ua.mateacademy.tania.lesson22;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplTest {
    private static final Order ORDER = new Order(BigDecimal.valueOf(121212), null,
            new Date(), "101", BigDecimal.valueOf(121),
            BigDecimal.valueOf(1214));
    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void test1InsertOrder() throws SQLException {
       assertTrue(orderDao.insertOrder(ORDER));
    }
}