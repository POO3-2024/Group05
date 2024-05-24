package com.example.springbootg5;

import domaine.Personnage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * class qui se charge de renvoyer tout les personnages et un personnage by id
 */
@RestController
@RequestMapping("/api")
public class personnageController {

    @GetMapping("/personnage")
    public List<Personnage> obtenirTousLesPersonnages() {
        List<Personnage> personnages = new ArrayList<>();
        String sql = "SELECT * FROM personnages";
        try (Connection connection = DaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String Name = resultSet.getString("Name");
                int pv = resultSet.getInt("pv");
                int mana = resultSet.getInt("mana");
                personnages.add(new Personnage(id, Name, pv, mana));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnages;
    }

    @GetMapping("/personnage/{id}")
    public Personnage obtenirPersonnageParId(@PathVariable int id) {
        Personnage personnage = null;
        String sql = "SELECT * FROM personnages WHERE id = ?";
        try (Connection connection = DaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String Name = resultSet.getString("Name");
                    int pv = resultSet.getInt("pv");
                    int mana = resultSet.getInt("mana");
                    personnage = new Personnage(id, Name, pv, mana);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnage;
    }
}
