

package com.example.springbootg5;

import domaine.Arme;
import domaine.Personnage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class qui va s'occuper de renvoyer l'attaque en prenant en entré le personnage attaqué avec l'arme utilisé
 */

@RestController
@RequestMapping("/api")
public class AttaqueController {

    @GetMapping("/attaque/{id_perso}/{id_arme}")
    public Personnage getAttaqueStats(@PathVariable int id_perso, @PathVariable int id_arme) {
        Personnage personnageAttaque = null;

        // Récupérer les détails du personnage attaqué
        String sqlPersonnage = "SELECT * FROM personnages WHERE id = ?";
        try (Connection connection = DaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlPersonnage)) {
            statement.setInt(1, id_perso);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("Name");
                int pv = resultSet.getInt("pv");
                int mana = resultSet.getInt("mana");

                // Créer un objet représentant le personnage attaqué
                personnageAttaque = new Personnage(id_perso, nom, pv, mana);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Récupérer les détails de l'arme
        int degatsArme = 0;
        String sqlArme = "SELECT degat FROM armes WHERE id = ?";
        try (Connection connection = DaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlArme)) {
            statement.setInt(1, id_arme);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                degatsArme = resultSet.getInt("degat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Soustraire les dégâts de l'arme aux points de vie du personnage
        if (personnageAttaque != null) {
            int nouveauxPv = personnageAttaque.getpv() - degatsArme;
            if (nouveauxPv < 0) {
                nouveauxPv = 0;
            }
            personnageAttaque.setpv(nouveauxPv);
        }

        return personnageAttaque;
    }

}