package ua.mateacademy.tania.lesson17.jdbc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OfficeDaoImplWithAbstractTemplate implements OfficeDao {

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

    @Override
    public Office getById(BigInteger id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Office office = null;

        try {
            connection = ConnectionDB.getConnection();
            preparedStatement = connection.prepareStatement("SELECT* FROM offices WHERE office=?");
            preparedStatement.setBigDecimal(1, new BigDecimal(id));
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                office = extraxtFromResultSet(rs);
            }
        } finally {
            rs.close();
            preparedStatement.close();
            connection.close();
        }

        return office;
    }

    @Override
    public boolean insert(Office office) throws SQLException {
        return new CRUDTemplateAbstract<Office>() {
            @Override
            public PreparedStatement returnPreparedStatement(Office office, Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO offices (office, city, region, mgr, target, sales ) VALUES (?,?,?,?,?,?) ");
                preparedStatement.setBigDecimal(1, new BigDecimal(office.getId()));
                preparedStatement.setString(2, office.getCity());
                preparedStatement.setString(3, office.getRegion());
                preparedStatement.setBigDecimal(4, new BigDecimal(office.getMgr()));
                preparedStatement.setBigDecimal(5, office.getTarget());
                preparedStatement.setBigDecimal(6, office.getSale());
                return preparedStatement;
            }
        }.templateOperation(office);
    }

    @Override
    public boolean update(Office office) throws SQLException {
        return new CRUDTemplateAbstract<Office>() {
            @Override
            public PreparedStatement returnPreparedStatement(Office office, Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE offices SET sales = ? WHERE office = ? ");
                preparedStatement.setBigDecimal(1, office.getSale());
                preparedStatement.setBigDecimal(2, new BigDecimal(office.getId()));
                return preparedStatement;
            }
        }.templateOperation(office);
    }

    @Override
    public boolean delete(Office office) throws SQLException {
        return new CRUDTemplate<Office>() {
            @Override
            public PreparedStatement returnPreparedStatement(Office office, Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM offices WHERE office = ?");

                preparedStatement.setBigDecimal(1, new BigDecimal(office.getId()));
                return preparedStatement;
            }
        }.templateOperation(office);
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
