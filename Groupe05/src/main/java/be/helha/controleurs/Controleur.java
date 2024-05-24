package be.helha.controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur principal pour la navigation entre les vues.
 * Auteur : LAMHAMDI Houssam Eddine
 */
public class Controleur {
    @FXML
    private Button btnMainMenu;

    @FXML
    private Label lblMenuTitle;

    @FXML
    private Label lblCharactDashBoTitle;

    /**
     * Aller à la liste des personnages
     *
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    public void goToListePersos(ActionEvent event) throws IOException {
        // Charger le fichier FXML pour la liste des personnages
        Parent root = FXMLLoader.load(getClass().getResource("/ListePersonnages.fxml"));
        // Créer une nouvelle scène
        Scene scene = new Scene(root);
        // Obtenir la fenêtre actuelle
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Définir la nouvelle scène pour la fenêtre
        stage.setScene(scene);
        // Afficher la nouvelle scène
        stage.show();
    }

    /**
     * Aller à la liste des armes
     *
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    public void goToListeArmes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ListeArmes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Retour au menu principal
     *
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    public void goToMainMenu(ActionEvent event) throws IOException {
        // Charger le fichier FXML pour le menu principal
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Aller à la modification des personnages
     *
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    public void goToModifPersonnages(ActionEvent event) throws IOException {
        // Charger le fichier FXML pour la modification des personnages
        Parent root = FXMLLoader.load(getClass().getResource("/ModifPersos.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Aller à l'ajout des personnages
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    public void goToAddPersos(ActionEvent event) throws IOException {
        // Charger le fichier FXML pour l'ajout des personnages
        Parent root = FXMLLoader.load(getClass().getResource("/AddPersos.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
