package ua.mateacademy.tania.lesson22;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficeDaoImplTest {
    private static final Office office = new Office(BigDecimal.valueOf(25), "киев", "region",
             BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
    private OfficeDao officeDao = new OfficeDaoImpl();

    @Test
    public void test1Insert() throws SQLException {
        assertTrue(officeDao.insert(office));
    }

    @Test
    public void test2Update() throws SQLException{
        office.setSales(BigDecimal.valueOf(2000));
        assertTrue(officeDao.update(office));
    }

    @Test
    public void test3Delete() throws SQLException {
        assertTrue(officeDao.delete(office.getOffice()));
    }
}