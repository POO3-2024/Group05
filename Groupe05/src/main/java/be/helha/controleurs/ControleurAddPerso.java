package be.helha.controleurs;

import be.helha.Personnage.Personnage;
import be.helha.dao.PersonnageDao;
import be.helha.daoimpl.DaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur pour gérer l'ajout d'un nouveau personnage.
 */
public class ControleurAddPerso {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPv;
    @FXML
    private TextField txtManna;

    private PersonnageDao personnageDao;

    /**
     * Gère l'ajout d'un nouveau personnage.
     *
     * @param event L'événement d'action déclenché par l'utilisateur.
     * @throws IOException En cas d'erreur de navigation.
     */
    @FXML
    private void ajouterPersonnage(ActionEvent event) throws IOException {
        this.personnageDao = (PersonnageDao) DaoFactory.getInstance().getDaoImpl(PersonnageDao.class);

        String nom = txtNom.getText().trim();
        String pvText = txtPv.getText().trim();
        String mannaText = txtManna.getText().trim();

        if (nom.isEmpty() || pvText.isEmpty() || mannaText.isEmpty()) {
            showErrorMessage("Champs requis", "Veuillez remplir tous les champs (Nom, PV, Manna).");
            return;
        }

        int pv, manna;
        try {
            pv = Integer.parseInt(pvText);
            manna = Integer.parseInt(mannaText);
        } catch (NumberFormatException e) {
            showErrorMessage("Erreur de format", "Veuillez entrer des nombres valides pour les points de vie et le manna.");
            return;
        }

        if (pv < 0 || pv > 1000 || manna < 0 || manna > 100) {
            showErrorMessage("Valeurs invalides", "Les points de vie doivent être entre 0 et 1000 et le manna entre 0 et 100.");
            return;
        }

        Personnage newPersonnage = new Personnage(nom, pv, manna);
        boolean ajout = personnageDao.ajouterPersonnage(newPersonnage);
        if (ajout) {
            showInfoMessage("Succès", "Personnage ajouté avec succès !");
        } else {
            showErrorMessage("Échec", "Échec de l'ajout du personnage.");
        }
    }

    /**
     * Affiche une alerte d'erreur.
     *
     * @param title   Le titre de l'alerte.
     * @param message Le message de l'alerte.
     */
    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Affiche une alerte d'information.
     *
     * @param title   Le titre de l'alerte.
     * @param message Le message de l'alerte.
     */
    private void showInfoMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Navigue vers le menu principal.
     *
     * @param event L'événement d'action déclenché par l'utilisateur.
     * @throws IOException En cas d'erreur de navigation.
     */
    @FXML
    private void goToMainMenu(ActionEvent event) throws IOException {
        navigateTo(event, "/MainMenu.fxml");
    }

    /**
     * Navigue vers la liste des personnages.
     *
     * @param event L'événement d'action déclenché par l'utilisateur.
     * @throws IOException En cas d'erreur de navigation.
     */
    @FXML
    private void listerPersonnages(ActionEvent event) throws IOException {
        navigateTo(event, "/ListePersonnages.fxml");
    }

    /**
     * Navigue vers un fichier FXML spécifié.
     *
     * @param event    L'événement d'action déclenché par l'utilisateur.
     * @param fxmlFile Le chemin du fichier FXML.
     * @throws IOException En cas d'erreur de navigation.
     */
    private void navigateTo(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
