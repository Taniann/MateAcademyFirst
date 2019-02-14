package ua.mateacademy.tania.lesson17.jdbc;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Tania Nebesna on 13.02.2019.
 */
public class OfficeDaoImplTest {

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
}