package be.helha.daoimpl;

import be.helha.dao.ArmeDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe fabrique pour obtenir les instances DAO.
 */
public class DaoFactory {
    private static ArmeDao armeDaoInstance;

    /**
     * Retourne une instance de ArmeDao.
     *
     * @return une instance de ArmeDao
     */
    public static ArmeDao getArmeDao() {
        if (armeDaoInstance == null) {
            armeDaoInstance = new ArmeDaoImpl(getConnection());
        }
        return armeDaoInstance;
    }

    /**
     * Établit une connexion à la base de données SQLite.
     *
     * @return une connexion à la base de données
     */
    public static Connection getConnection() {
        String url = "jdbc:sqlite:C:\\sqlite\\db\\poo3.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
