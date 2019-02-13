package ua.mateacademy.tania.lesson17.jdbc;

import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Tania Nebesna on 13.02.2019.
 */
public interface OfficeDao {
    Set<Office> getAll() throws SQLException;
    Set<Office> getAllByRegion(String region) throws SQLException;
}
