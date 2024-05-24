package be.helha.controleurs;

import be.helha.dao.ArmeDao;
import be.helha.daoimpl.DaoFactory;
import be.helha.domaine.Arme;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur pour ajouter une arme.
 * Auteur : LAMHAMDI Houssam Eddine
 */
public class ControleurAddArme {
    @FXML private TextField nomArmeField;
    @FXML private TextField typeArmeField;

    private ArmeDao armeDao;

    /**
     * Ici on initialise le controleur
     */
    @FXML
    public void initialize() {
        armeDao = DaoFactory.getArmeDao();
    }

    /**
     * Ajoute une nouvelle arme.
     */
    @FXML
    private void ajouterArme() {
        String nom = nomArmeField.getText();
        int degats;
        try {
            // Vérifie si les dégâts sont un nombre
            degats = Integer.parseInt(typeArmeField.getText());
            if (degats > 100) {
                // Afficher un message d'erreur si les dégâts dépassent 100
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Les degats ne peuvent pas depasser 100.");
                alert.showAndWait();
                return;
            }
        } catch (NumberFormatException e) {
            // Afficher un message d'erreur si les dégâts ne sont pas un nombre
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le champ degats doit etre rempli et etre un nombre entier.");
            alert.showAndWait();
            return;
        }

        if (nom.isEmpty()) {
            // Afficher un message d'erreur si le nom est vide
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le nom de l'arme ne peut pas etre vide.");
            alert.showAndWait();
            return;
        }

        Arme arme = new Arme(0, nom, degats);
        boolean ajoutReussi = armeDao.ajouterArme(arme);
        if (ajoutReussi) {
            // Afficher une boîte de dialogue de confirmation
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Succes");
            alert.setHeaderText(null);
            alert.setContentText("L'arme a ete ajoutee avec succes.");
            alert.showAndWait();
        } else {
            // Afficher une boîte de dialogue d'erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Une erreur s'est produite lors de l'ajout de l'arme.");
            alert.showAndWait();
        }
    }

    /**
     * Aller à la liste des armes
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    private void goToListeArmes(javafx.event.ActionEvent event) throws IOException {
        // Charger le fichier FXML pour la liste des armes
        Parent root = FXMLLoader.load(getClass().getResource("/ListeArmes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
