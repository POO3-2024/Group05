package be.helha.daoimpl;

import be.helha.dao.ArmeDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private static final String URL = "jdbc:sqlite:/c:/sqlite/db/poo3.db";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArmeDao getArmeDao() {
        return new ArmeDaoImpl(getConnection());
    }
}
