package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.OpCreditProofDAO;
import project.DAO.mappers.Mapper;
import project.DAO.mappers.OpCreditProofMapper;
import project.DAO.queries.OpCreditProofSQL;
import project.model.OpCreditProof;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OpCreditProofJDBC implements OpCreditProofDAO {

    private static final Logger LOG = Logger.getLogger(OpCreditProofJDBC.class);
    private Connection connection;

    public OpCreditProofJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(OpCreditProof entity) {
        try (PreparedStatement ps = connection.prepareStatement(OpCreditProofSQL.INSERT_TO_OP_CREDITPROOF_TABLE.getQUERY())) {
            LOG.debug("Executed query" + OpCreditProofSQL.INSERT_TO_OP_CREDITPROOF_TABLE);
            ps.setInt(1, entity.getUserId());
            ps.setInt(2, entity.getManagerId());
            ps.setDate(3, entity.getOperationDate());
            ps.setBoolean(4, entity.getDecision());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in OpCreditProofJDBC.class from create() method", e);
        }
    }

    @Override
    public List<OpCreditProof> getAllById(int id) {
        List<OpCreditProof> allOperations = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(OpCreditProofSQL.GET_ALL_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + OpCreditProofSQL.GET_ALL_BY_ID);
            Mapper<OpCreditProof> opCreditProofMapper = new OpCreditProofMapper();

            while (rs.next()) {
                LOG.debug("Read Operations CreditProof from DB");
                OpCreditProof opCreditProof = opCreditProofMapper.getEntity(rs);
                allOperations.add(opCreditProof);
            }
            return allOperations;
        } catch (SQLException e) {
            LOG.error("SQLException occurred in OpCreditProofJDBC.class from getAllById() method", e);
            return null;
        }
    }

    @Override
    public OpCreditProof getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<OpCreditProof> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(OpCreditProof opCreditProof) {
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
            LOG.error("SQLException occurred in OpCreditProofJDBC.class from close() method", e);
            throw new RuntimeException(e);
        }
    }
}
