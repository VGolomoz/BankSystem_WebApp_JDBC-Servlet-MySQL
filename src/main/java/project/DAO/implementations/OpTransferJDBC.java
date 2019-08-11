package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.OpTransferDAO;
import project.DAO.mappers.Mapper;
import project.DAO.mappers.OpTransferMapper;
import project.DAO.queries.OpTransferSQL;
import project.model.entities.OpTransfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpTransferJDBC implements OpTransferDAO {


    private static final Logger LOG = Logger.getLogger(OpTransferJDBC.class);
    private Connection connection;

    public OpTransferJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<OpTransfer> getAllById(int id) {

        List<OpTransfer> allOperations = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(OpTransferSQL.GET_ALL_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + OpTransferSQL.GET_ALL_BY_ID);
            Mapper<OpTransfer> opTransferMapper = new OpTransferMapper();
            while (rs.next()) {
                LOG.debug("Read Operations Transfer from DB");
                OpTransfer opTransfer = opTransferMapper.getEntity(rs);
                allOperations.add(opTransfer);
            }
            return allOperations;
        } catch (SQLException e) {
            LOG.error("SQLException occurred in OpTransferJDBC.class from getAllById() method", e);
            return null;
        }
    }

    @Override
    public void create(OpTransfer entity) {
        try (PreparedStatement ps = connection.prepareStatement(OpTransferSQL.INSERT_TO_OP_TRANSFER_TABLE.getQUERY())) {
            ps.setInt(1, entity.getUserId());
            ps.setString(2, entity.getRecipientMail());
            ps.setFloat(3, entity.getAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in OpTransferJDBC.class from create() method", e);
        }
    }

    @Override
    public OpTransfer getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<OpTransfer> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(OpTransfer opTransfer) {
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
            LOG.error("SQLException occurred in OpTransferJDBC.class from close() method", e);
            throw new RuntimeException(e);
        }
    }
}
