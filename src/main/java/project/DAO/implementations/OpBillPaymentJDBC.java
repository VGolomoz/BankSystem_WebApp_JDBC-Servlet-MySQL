package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.OpBillPaymentDAO;
import project.DAO.mappers.Mapper;
import project.DAO.mappers.OpBillPaymentMapper;
import project.DAO.queries.OpBillPaymentSQL;
import project.model.OpBillPayment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OpBillPaymentJDBC implements OpBillPaymentDAO {

    private static final Logger LOG = Logger.getLogger(OpBillPaymentJDBC.class);
    private Connection connection;

    public OpBillPaymentJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<OpBillPayment> getAllById(int id) {

        List<OpBillPayment> allOperations = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(OpBillPaymentSQL.GET_ALL_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + OpBillPaymentSQL.GET_ALL_BY_ID);
            Mapper<OpBillPayment> opBillPaymentMapper = new OpBillPaymentMapper();

            while (rs.next()) {
                LOG.debug("Read Operations BillPayment from DB");
                OpBillPayment opBillPayment = opBillPaymentMapper.getEntity(rs);
                allOperations.add(opBillPayment);
            }
            return allOperations;
        } catch (SQLException e) {
            LOG.error("SQLException occurred in OpBillPaymentJDBC.class from getAllById() method", e);
            return null;
        }
    }


    @Override
    public void create(OpBillPayment entity) {

        try (PreparedStatement ps = connection.prepareStatement(OpBillPaymentSQL.INSERT_TO_OP_BILLPAYMENT_TABLE.getQUERY())) {
            LOG.debug("Executed query" + OpBillPaymentSQL.INSERT_TO_OP_BILLPAYMENT_TABLE);
            ps.setInt(1, entity.getUserId());
            ps.setString(2, entity.getBillNumber());
            ps.setString(3, entity.getPurpose());
            ps.setFloat(4, entity.getAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in OpBillPaymentJDBC.class from create() method", e);
        }
    }

    @Override
    public OpBillPayment getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<OpBillPayment> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(OpBillPayment opBillPayment) {
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
