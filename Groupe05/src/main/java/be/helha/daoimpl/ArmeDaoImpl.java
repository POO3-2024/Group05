package be.helha.daoimpl;

import be.helha.dao.ArmeDao;
import be.helha.domaine.Arme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArmeDaoImpl implements ArmeDao {
    private Connection connection;

    public ArmeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouterArme(Arme arme) {
        String sql = "INSERT INTO armes (nom, degats) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, arme.getNom());
            pstmt.setInt(2, arme.getDegats());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                arme.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Arme obtenirArmeParId(int id) {
        String sql = "SELECT * FROM armes WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Arme(rs.getInt("id"), rs.getString("nom"), rs.getInt("degats"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Arme> obtenirToutesLesArmes() {
        List<Arme> armes = new ArrayList<>();
        String sql = "SELECT * FROM armes";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                armes.add(new Arme(rs.getInt("id"), rs.getString("nom"), rs.getInt("degats")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armes;
    }

    @Override
    public void mettreAJourArme(Arme arme) {
        String sql = "UPDATE armes SET nom = ?, degats = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, arme.getNom());
            pstmt.setInt(2, arme.getDegats());
            pstmt.setInt(3, arme.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerArme(int id) {
        String sql = "DELETE FROM armes WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
