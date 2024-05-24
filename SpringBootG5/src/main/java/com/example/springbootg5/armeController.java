package com.example.springbootg5;

import domaine.Arme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class armeController {

    @GetMapping("/arme")
    public List<Arme> obtenirToutesLesArmes() {
        List<Arme> armes = new ArrayList<>();
        String sql = "SELECT * FROM armes";
        try (Connection connection = DaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
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
}
