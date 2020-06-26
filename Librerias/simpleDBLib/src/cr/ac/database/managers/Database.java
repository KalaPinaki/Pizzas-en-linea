package cr.ac.database.managers;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public abstract class Database {

    // <editor-fold defaultstate="collapsed" desc="constructors">
    public Database(DBManager.DB_MGR serverType, String configurationFileName)
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException {
        configuration = new Properties();
        try {
            configuration.load(getClass().getResourceAsStream(configurationFileName));
            try {
                dbmgr = DBManager.getDBManager(serverType,
                        configuration.getProperty("server_url"));
            } catch (IOException
                    | ClassNotFoundException
                    | IllegalAccessException
                    | InstantiationException ex) {
                System.err.println("Couldn't load database driver..");
                System.err.printf("Exception: '%s'%n", ex.getMessage());
                throw ex;
            }
        } catch (IOException ex) {
            System.err.println("Couldn't read configuration file..");
            throw ex;
        }
    }

    public Database(DBManager.DB_MGR serverType)
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException {
        this(serverType, CONFIGURATION_FILE);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="methods">
    public Connection getConnection()
            throws SQLException {
        return getConnection(configuration.getProperty("database"));
    }

    public Connection getConnection(String databaseName)
            throws SQLException {
        return dbmgr.getConnection(
                databaseName,
                configuration.getProperty("user"),
                configuration.getProperty("password")
        );
    }

    public void closeConnection() {
        dbmgr.closeConnection();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="DB attributes">
    private static final String CONFIGURATION_FILE = "./bd.properties";
    private final Properties configuration;
    private DBManager dbmgr;
    // </editor-fold>
}
