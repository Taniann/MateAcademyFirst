package ua.mateacademy.tania.lesson22;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface OfficeDao {
    boolean insert(Office office) throws SQLException;

    boolean update(Office office) throws SQLException;

    boolean delete(BigDecimal id) throws SQLException;
}
