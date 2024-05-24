package com.example.springbootg5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe fabrique pour obtenir les instances DAO.
 */
public class DaoFactory {
    /**
     * Établit une connexion à la base de données SQLite.
     *
     * @return une connexion à la base de données
     */
    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:\\sqlite\\db\\poo3.db";
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'obtention de la connexion à la base de données", e);
        }
    }

}