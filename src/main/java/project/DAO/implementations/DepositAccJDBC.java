package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.DepositAccDAO;
import project.DAO.mappers.DepositAccMapper;
import project.DAO.mappers.Mapper;
import project.DAO.queries.DepositAccSQL;
import project.model.DepositAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepositAccJDBC implements DepositAccDAO {

    private static final Logger LOG = Logger.getLogger(DepositAccJDBC.class);
    private Connection connection;

    public DepositAccJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(DepositAccount entity) {
        try (PreparedStatement ps = connection.prepareStatement(DepositAccSQL.INSERT_TO_DEPOSIT_ACCOUNT_TABLE.getQUERY())) {
            LOG.debug("Executed query" + DepositAccSQL.INSERT_TO_DEPOSIT_ACCOUNT_TABLE);
            ps.setInt(1, entity.getUserId());
            ps.setFloat(2, entity.getBalance());
            ps.setString(3, entity.getCurrency());
            ps.setFloat(4, entity.getRate());
            ps.setDate(5, entity.getTerm());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in DepositAccJDBC.class from create() method", e);
        }
    }

    @Override
    public DepositAccount getById(int id) {
        Mapper<DepositAccount> depositAccountMapper = new DepositAccMapper();
        DepositAccount result = new DepositAccount();
        result.setUserId(-1);

        try (PreparedStatement ps = connection.prepareStatement(DepositAccSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + DepositAccSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("Check is ResultSet has next");
                result = depositAccountMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in DepositAccJDBC.class from getById() method", e);
        }
        return result;
    }

    @Override
    public List<DepositAccount> findAll() {
       throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(DepositAccount depositAccount) {
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
            LOG.error("SQLException occurred in DepositAccJDBC.class from close() method", e);
            throw new RuntimeException(e);
        }
    }
}
