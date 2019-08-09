package project.DAO.implementations;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import project.util.DBConfig;
import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource {

    private static final Logger LOG = Logger.getLogger(DBCPDataSource.class);
    private static final BasicDataSource dataSource = new BasicDataSource();

    private static final String DB_URL = DBConfig.getUrl();
    private static final String DB_USER = DBConfig.getUser();
    private static final String DB_PASSWORD = DBConfig.getPassword();

    static {
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(20);
        dataSource.setInitialSize(5);

    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            LOG.debug("Connection received " + connection);
        } catch (SQLException e) {
            LOG.error("SQLException occurred in DBCPDataSource.class from getConnection() method" + e);
        }
        return connection;
    }

    private DBCPDataSource() {
    }
}
