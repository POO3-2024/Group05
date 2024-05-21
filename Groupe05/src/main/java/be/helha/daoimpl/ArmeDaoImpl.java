package be.helha.daoimpl;

import be.helha.dao.ArmeDao;
import be.helha.domaine.Arme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArmeDaoImpl implements ArmeDao {

    private final Connection connection;

    public ArmeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Arme> obtenirToutesLesArmes() {
        List<Arme> armes = new ArrayList<>();
        String sql = "SELECT * FROM armes";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                int degats = resultSet.getInt("degats");
                armes.add(new Arme(id, nom, degats));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armes;
    }

    @Override
    public void ajouterArme(Arme arme) {
        String sql = "INSERT INTO armes (nom, degats) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, arme.getNom());
            statement.setInt(2, arme.getDegats());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerArme(int id) {
        String sql = "DELETE FROM armes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mettreAJourArme(Arme arme) {
        String sql = "UPDATE armes SET nom = ?, degats = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, arme.getNom());
            statement.setInt(2, arme.getDegats());
            statement.setInt(3, arme.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Arme obtenirArmeParId(int id) {
        Arme arme = null;
        String sql = "SELECT * FROM armes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                int degats = resultSet.getInt("degats");
                arme = new Arme(id, nom, degats);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arme;
    }
}
