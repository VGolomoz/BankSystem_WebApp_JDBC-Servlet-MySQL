package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.ContactDetailsDAO;
import project.DAO.mappers.ContactDetailsMapper;
import project.DAO.mappers.Mapper;
import project.DAO.queries.ContactDetailsSQL;
import project.model.entities.ContactDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactDetailsJDBC implements ContactDetailsDAO {

    private static final Logger LOG = Logger.getLogger(UserJDBC.class);
    private Connection connection;

    public ContactDetailsJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ContactDetails entity) {

        try (PreparedStatement ps = connection.prepareStatement(ContactDetailsSQL.INSERT_TO_CONTACT_DETAILS_TABLE.getQUERY())) {
            LOG.debug("Executed query" + ContactDetailsSQL.INSERT_TO_CONTACT_DETAILS_TABLE);
            ps.setInt(1, entity.getUserId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getAddress());
            ps.setString(5, entity.getMail());
            ps.setString(6, entity.getMobile_phone());
            ps.setDate(7, entity.getBirthday());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in ContactDetailsJDBC.class from create() method", e);
        }

    }

    @Override
    public ContactDetails getById(int id) {
        Mapper<ContactDetails> contactDetailsMapper = new ContactDetailsMapper();
        ContactDetails result = new ContactDetails();
        result.setUserId(-1);

        try (PreparedStatement ps = connection.prepareStatement(ContactDetailsSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + ContactDetailsSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("Check is ResultSet has next");
                result = contactDetailsMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in ContactDetailsJDBC.class from getById() method", e);
        }
        return result;
    }

    @Override
    public List<ContactDetails> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(ContactDetails contactDetailsDAO) {
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
            LOG.error("SQLException occurred in ContactDetailsJDBC.class from close() method", e);
            throw new RuntimeException(e);
        }
    }
}
