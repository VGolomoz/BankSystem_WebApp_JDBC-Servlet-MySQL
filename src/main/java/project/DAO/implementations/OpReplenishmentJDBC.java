package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.OpReplenishmentDAO;
import project.DAO.mappers.Mapper;
import project.DAO.mappers.OpReplenishmentMapper;
import project.DAO.queries.OpReplenishmentSQL;
import project.model.entities.OpReplenishment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpReplenishmentJDBC implements OpReplenishmentDAO {

    private static final Logger LOG = Logger.getLogger(OpReplenishmentJDBC.class);
    private Connection connection;

    public OpReplenishmentJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<OpReplenishment> getAllById(int id) {

        List<OpReplenishment> allOperations = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(OpReplenishmentSQL.GET_ALL_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + OpReplenishmentSQL.GET_ALL_BY_ID);
            Mapper<OpReplenishment> opReplenishmentMapper = new OpReplenishmentMapper();
            while (rs.next()) {
                LOG.debug("Read Operations Replenishment from DB");
                OpReplenishment opReplenishment = opReplenishmentMapper.getEntity(rs);
                allOperations.add(opReplenishment);
            }
            return allOperations;
        } catch (SQLException e) {
            LOG.error("SQLException occurred in OpReplenishmentJDBC.class from getAllById() method", e);
            return null;
        }
    }

    @Override
    public void create(OpReplenishment entity) {
        try(PreparedStatement ps = connection.prepareStatement(OpReplenishmentSQL.INSERT_TO_OP_REPLENISHMENT_TABLE.getQUERY())) {
            ps.setInt(1, entity.getUserId());
            ps.setFloat(2, entity.getAmount());
            ps.setString(3, entity.getAccName());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in OpReplenishmentJDBC.class from create() method", e);
        }
    }

    @Override
    public OpReplenishment getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<OpReplenishment> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(OpReplenishment opReplenishment) {
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
            LOG.error("SQLException occurred in OpReplenishmentJDBC.class from close() method", e);
            throw new RuntimeException(e);
        }
    }
}
