package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tania Nebesna on 13.02.2019.
 */
public class OfficeDaoImpl implements OfficeDao {

    @Override
    public Set<Office> getAll() throws SQLException {
        Set<Office> offices = new HashSet<>();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT* FROM offices");
             ResultSet rs = preparedStatement.executeQuery()
        ) {

            while (rs.next()) {
                offices.add(extraxtFromResultSet(rs));
            }
        }
        return offices;
    }

    @Override
    public Set<Office> getAllByRegion(String region) throws SQLException {
        Set<Office> offices = new HashSet<>();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT* FROM offices WHERE region = ?");
        ) {

            preparedStatement.setString(1, region);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                offices.add(extraxtFromResultSet(rs));
            }
        }
        return offices;
    }

    private Office extraxtFromResultSet(ResultSet rs) throws SQLException {
        BigInteger id = rs.getBigDecimal("office").toBigInteger();
        String city = rs.getString("city");
        String region = rs.getString("region");
        BigInteger mgr = rs.getBigDecimal("mgr").toBigInteger();
        BigDecimal target = rs.getBigDecimal("target");
        BigDecimal sales = rs.getBigDecimal("sales");

        Office office = new Office(id, city, region, mgr, target, sales);

        return office;
    }
}
