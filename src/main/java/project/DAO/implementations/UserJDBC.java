package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.UserDAO;
import project.DAO.mappers.UserMapper;
import project.DAO.mappers.Mapper;
import project.DAO.queries.DBFields.UsersFields;
import project.DAO.queries.UserSQL;
import project.model.User;
import project.util.MyExceptions.WrongPasswordException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserJDBC implements UserDAO {

    private static final Logger LOG = Logger.getLogger(UserJDBC.class);
    private Connection connection;

    public UserJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean isUserExists(String mail) {
        try (PreparedStatement ps = connection.prepareStatement(UserSQL.READ_BY_MAIL.getQUERY())) {
            ps.setString(1, mail);
            final ResultSet rs = ps.executeQuery();

            LOG.debug("Executed query" + UserSQL.READ_BY_MAIL);
            if (rs.next()) {
                LOG.debug("Check is ResultSet has next");
                return true;
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in UserJDBC.class from isUserExist() method", e);
        }
        return false;
    }

    public int getUserIdByMail(String mail) {
        int id = -1;
        try (PreparedStatement ps = connection.prepareStatement(UserSQL.READ_ID_BY_MAIL.getQUERY())) {
            ps.setString(1, mail);
            final ResultSet rs = ps.executeQuery();

            LOG.debug("Executed query" + UserSQL.READ_ID_BY_MAIL);
            if (rs.next()) {
                LOG.debug("Check is ResultSet has next");
                id = rs.getInt(UsersFields.USER_ID);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in UserJDBC.class from getUserIdByMail() method", e);
        }
        return id;

    }

    @Override
    public User getUserByMailAndPass(String mail, String pass) throws WrongPasswordException {
        Mapper<User> userMapper = new UserMapper();
        User result = null;

        try (PreparedStatement ps = connection.prepareStatement(UserSQL.READ_BY_MAIL_AND_PASS.getQUERY())) {
            ps.setString(1, mail);
            ps.setString(2, pass);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + UserSQL.READ_BY_MAIL_AND_PASS);
            if (rs.next()) {
                LOG.debug("Check is ResultSet has next");
                result = userMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in UserJDBC.class from getUserByMailAndPass() method", e);
        }
        if (result == null) throw new WrongPasswordException("Wrong password");
        else return result;
    }

    @Override
    public void create(User user) {
        try (PreparedStatement ps = connection.prepareStatement(UserSQL.INSERT_TO_USERS_TABLE.getQUERY())) {
            LOG.debug("Executed query" + UserSQL.INSERT_TO_USERS_TABLE);
            ps.setString(1, user.getMail());
            ps.setString(2, user.getPass());
            ps.setInt(3, user.getRoleId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("SQLException occurred in UserJDBC.class from create() method", e);
        }
    }

    @Override
    public User getById(int id) {
        Mapper<User> userMapper = new UserMapper();
        User result = new User();
        result.setUserId(-1);

        try (PreparedStatement ps = connection.prepareStatement(UserSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + UserSQL.READ_BY_ID);
            if (rs.next()) {
                LOG.debug("Check is ResultSet has next");
                result = userMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.error("SQLException occurred in UserJDBC.class from getById() method", e);
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        final String query = UserSQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            LOG.debug("Executed query" + UserSQL.READ_ALL);
            Mapper<User> clientMapper = new UserMapper();

            while (rs.next()) {
                LOG.debug("Read clients from DB");
                User userFromDB = clientMapper.getEntity(rs);
                allUsers.add(userFromDB);
            }
            return allUsers;
        } catch (SQLException e) {
            LOG.error("SQLException occurred in UserJDBC.class from findAll() method", e);
            return null;
        }
    }

    @Override
    public boolean update(User user) {
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
            LOG.error("SQLException occurred in UserJDBC.class from close() method", e);
            throw new RuntimeException(e);
        }
    }
}