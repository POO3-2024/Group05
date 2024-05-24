package be.helha.daoimpl;

import be.helha.dao.Dao;
import be.helha.dao.PersonnageDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoFactory {

    private static final String FICHIER_CONFIGURATION = "src/main/resources/config.json";
    private static final String FICHIER_CONFIGURATION_TESTS = "src/main/resources/configTest.json";

    private static PersonnageDao personnageDaoInstance;

    private static final DaoFactory INSTANCE = new DaoFactory();

    private Persistance persistance;

    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    private DaoFactory() {
        try {
            this.persistance = ParserConfig.lireConfiguration(FICHIER_CONFIGURATION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTestConfiguration() {
        try {
            this.persistance = ParserConfig.lireConfiguration(FICHIER_CONFIGURATION_TESTS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnexion() throws SQLException {
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(persistance.getUrl());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connexion;
    }

    public Dao getDaoImpl(Class<? extends Dao> interfaceDao) {
        return this.persistance.getDaoImpl(interfaceDao);
    }
}
