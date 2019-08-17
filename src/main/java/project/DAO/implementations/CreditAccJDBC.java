package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.CreditAccDAO;
import project.DAO.mappers.CreditAccMapper;
import project.DAO.mappers.Mapper;
import project.DAO.queries.CreditAccSQL;
import project.model.CreditAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CreditAccJDBC implements CreditAccDAO {

    private static final Logger LOG = Logger.getLogger(CreditAccJDBC.class);
    private Connection connection;

    public CreditAccJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(CreditAccount entity) {

        try (PreparedStatement ps = connection.prepareStatement(CreditAccSQL.INSERT_TO_CREDIT_ACCOUNT_TABLE.getQUERY())) {
            LOG.debug("Executed query" + CreditAccSQL.INSERT_TO_CREDIT_ACCOUNT_TABLE);
            ps.setInt(1, entity.getUserId());
            ps.setFloat(2, entity.getBalance());
            ps.setString(3, entity.getCurrency());
            ps.setFloat(4, entity.getLimit());
            ps.setFloat(5, entity.getRate());
            ps.setFloat(6, entity.getAccrued_interest());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in CreditAccJDBC.class from create() method", e);
        }
    }

    @Override
    public CreditAccount getById(int id) {
        Mapper<CreditAccount> creditAccountMapper = new CreditAccMapper();
        CreditAccount result = new CreditAccount();
        result.setUserId(-1);

        try (PreparedStatement ps = connection.prepareStatement(CreditAccSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + CreditAccSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("Check is ResultSet has next");
                result = creditAccountMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in CreditAccJDBC.class from getById() method", e);
        }
        return result;
    }

    @Override
    public List<CreditAccount> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(CreditAccount creditAccount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
        try {
            connection.close();
            LOG.debug("Connection closed");
        } catch (SQLException e) {
            LOG.error("SQLException occurred in CreditAccJDBC.class from close() method", e);
            throw new RuntimeException(e);
        }
    }
}
