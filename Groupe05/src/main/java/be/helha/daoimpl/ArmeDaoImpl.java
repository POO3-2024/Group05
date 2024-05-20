package be.helha.daoimpl;

import be.helha.dao.ArmeDao;
import be.helha.domaine.Arme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de l'interface ArmeDao pour les opérations CRUD sur les armes.
 */
public class ArmeDaoImpl implements ArmeDao {
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
    public void ajouterArme(Arme arme) {
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
    public List<Arme> obtenirToutesLesArmes() {
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
    public void mettreAJourArme(Arme arme) {
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
    public void supprimerArme(int id) {
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
