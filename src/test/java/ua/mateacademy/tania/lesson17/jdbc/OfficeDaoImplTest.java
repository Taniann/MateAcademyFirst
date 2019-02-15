package ua.mateacademy.tania.lesson17.jdbc;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Tania Nebesna on 13.02.2019.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficeDaoImplTest {
    private static final BigInteger NOT_EXIST_OFFICE = BigInteger.valueOf(26);
    private static final BigInteger ALREADY_EXIST_OFFICE = BigInteger.valueOf(21);
    private static final Office office = new Office(BigInteger.valueOf(25), "киев", "region",
            BigInteger.valueOf(110), BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

    private OfficeDao officeDao = new OfficeDaoImpl();

    @Test
    public void testGetAll() throws SQLException {
        Set<Office> offices = officeDao.getAll();
        System.out.println(offices);
        System.out.println(offices.size());
        assertTrue(offices.size() != 0);
    }

    @Test
    public void testGetAllByRegion() throws SQLException {
        Set<Office> offices = officeDao.getAllByRegion("Запад");
        System.out.println(offices);
        System.out.println(offices.size());
        assertTrue(offices.size() != 0);
        assertEquals(offices.iterator().next().getRegion(), "Запад");
    }

    @Test
    public void testGetById() throws SQLException {
        Office office = officeDao.getById(ALREADY_EXIST_OFFICE);
        assertNotNull(office);
    }

    @Test
    public void testFindOrderByIdNotPresent() throws SQLException {
        Office office = officeDao.getById(NOT_EXIST_OFFICE);
        assertNull(office);
    }

    @Test
    public void test1Insert() throws SQLException {
        officeDao.insert(office);
        Set<Office> offices = officeDao.getAll();
        assertTrue(offices.contains(office));
    }

    @Test
    public void test2Update() throws SQLException {
        office.setSale(BigDecimal.valueOf(2000));
        officeDao.update(office);
        Office office = officeDao.getById(BigInteger.valueOf(25));
        assertEquals(BigDecimal.valueOf(2000), office.getSale());
    }

    @Test
    public void test3Delete() throws SQLException {
        officeDao.delete(BigInteger.valueOf(25));
        Set<Office> offices = officeDao.getAll();
        assertFalse(offices.contains(office));
    }
}