// src/main/java/be/helha/daoimpl/DaoImpl.java
package be.helha.daoimpl;

import be.helha.dao.Dao;
import be.helha.domaine.Arme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation générique de l'interface Dao pour les armes.
 */
public class DaoImpl implements Dao<Arme> {
    private final String url = "jdbc:sqlite:C:\\sqlite\\db\\poo3.db";

    /**
     * Connecte à la base de données SQLite.
     * @return la connexion à la base de données
     * @throws SQLException en cas d'erreur de connexion
     */
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Override
    public void ajouter(Arme arme) {
        String sql = "INSERT INTO armes(nom, degats) VALUES(?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, arme.getNom());
            pstmt.setInt(2, arme.getDegats());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Arme> obtenirTous() {
        String sql = "SELECT id, nom, degats FROM armes";
        List<Arme> armes = new ArrayList<>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Arme arme = new Arme(rs.getInt("id"), rs.getString("nom"), rs.getInt("degats"));
                armes.add(arme);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return armes;
    }

    @Override
    public void mettreAJour(Arme arme) {
        String sql = "UPDATE armes SET nom = ?, degats = ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, arme.getNom());
            pstmt.setInt(2, arme.getDegats());
            pstmt.setInt(3, arme.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        String sql = "DELETE FROM armes WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

