package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.UserAccDAO;
import project.DAO.mappers.Mapper;
import project.DAO.mappers.UserAccMapper;
import project.DAO.queries.UserAccSQL;
import project.model.entities.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserAccJDBC implements UserAccDAO {

    private static final Logger LOG = Logger.getLogger(UserJDBC.class);
    private Connection connection;

    public UserAccJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(UserAccount entity) {
        try (PreparedStatement ps = connection.prepareStatement(UserAccSQL.INSERT_TO_USER_ACCOUNT_TABLE.getQUERY())) {
            LOG.debug("Executed query" + UserAccSQL.INSERT_TO_USER_ACCOUNT_TABLE);
            ps.setInt(1, entity.getUserId());
            ps.setString(2, entity.getCurrency());
            ps.setDate(3, entity.getValidity());
            ps.setFloat(4, entity.getBalance());
            ps.setBoolean(5, entity.getDeposit());
            ps.setBoolean(6, entity.getCredit());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in UserAccJDBC.class from create() method", e);
        }
    }

    @Override
    public UserAccount getById(int id) {
        Mapper<UserAccount> userAccMapper = new UserAccMapper();
        UserAccount result = new UserAccount();
        result.setUserId(-1);

        try (PreparedStatement ps = connection.prepareStatement(UserAccSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + UserAccSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("Check is ResultSet has next");
                result = userAccMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in UserAccJDBC.class from getById() method", e);
        }
        return result;
    }

    @Override
    public List<UserAccount> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(UserAccount userAccount) {
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
            LOG.error("SQLException occurred in UserAccJDBC.class from close() method", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateDepositStatusById(int id) {
        try (PreparedStatement ps = connection.prepareStatement(UserAccSQL.UPDATE_DEPOSIT_STATUS_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            ps.executeUpdate();
            LOG.debug("Executed query" + UserAccSQL.UPDATE_DEPOSIT_STATUS_BY_ID);
        } catch (SQLException e) {
            LOG.error("SQLException occurred in UserAccJDBC.class from updateDepositStatusById() method", e);
        }
    }
}


