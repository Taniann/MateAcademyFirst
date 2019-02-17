package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Tania Nebesna on 13.02.2019.
 */
public interface OfficeDao {
    Set<Office> getAll() throws SQLException;

    Set<Office> getAllByRegion(String region) throws SQLException;

    Office getById(BigInteger id) throws SQLException;

    boolean insert(Office office) throws SQLException;

    boolean update(Office office) throws SQLException;

    boolean delete(BigInteger id) throws SQLException;
}
