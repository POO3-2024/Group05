package be.helha.controleurs;

import be.helha.dao.ArmeDao;
import be.helha.daoimpl.DaoFactory;
import be.helha.domaine.Arme;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur pour ajouter une arme.
 */
public class ControleurAddArme {
    @FXML private TextField nomArmeField;
    @FXML private TextField typeArmeField;
    @FXML private Button ajouterButton;

    private ArmeDao armeDao;

    /**
     * Initialisation du contrôleur.
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
            degats = Integer.parseInt(typeArmeField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Arme ajoutée avec succès");
            e.printStackTrace();
            return;
        }

        if (!nom.isEmpty()) {
            Arme arme = new Arme(0, nom, degats);
            armeDao.ajouterArme(arme);
            System.out.println("Arme ajoutée avec succès");
        } else {
            System.err.println("Le nom de l'arme ne peut pas être vide");
        }
    }

    /**
     * Navigue vers la liste des armes.
     *
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    private void goToListeArmes(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ListeArmes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
