package ua.mateacademy.tania.lesson22;

import java.math.BigDecimal;

public interface OfficeDao {
    boolean insert(Office office);

    boolean update(Office office);

    boolean delete(BigDecimal id);
}
