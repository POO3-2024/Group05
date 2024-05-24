package be.helha.controleurs;

import be.helha.dao.ArmeDao;
import be.helha.daoimpl.DaoFactory;
import be.helha.domaine.Arme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur pour mettre à jour les armes.
 * Auteur : LAMHAMDI Houssam Eddine
 */
public class ControleurUpdateArmes {
    @FXML
    private TableView<Arme> tableArmes;
    @FXML
    private TableColumn<Arme, Integer> columnId;
    @FXML
    private TableColumn<Arme, String> columnNom;
    @FXML
    private TableColumn<Arme, Integer> columnDegats;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textDegats;

    private ArmeDao armeDao;
    private ObservableList<Arme> armes;

    /**
     * Initialisation du contrôleur.
     */
    @FXML
    public void initialize() {
        armeDao = DaoFactory.getArmeDao();
        armes = FXCollections.observableArrayList(armeDao.obtenirToutesLesArmes());

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnDegats.setCellValueFactory(new PropertyValueFactory<>("degats"));

        tableArmes.setItems(armes);
    }

    /**
     * Met à jour l'arme sélectionnée.
     * @param event l'événement de clic
     */
    @FXML
    private void mettreAJourArme(ActionEvent event) {
        Arme selectedArme = tableArmes.getSelectionModel().getSelectedItem();
        if (selectedArme != null) {
            String nom = textNom.getText();
            if (nom.isEmpty()) {
                // Afficher un message d'erreur si le nom est vide
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Le nom de l'arme ne peut pas etre vide.");
                alert.showAndWait();
                return;
            }
            selectedArme.setNom(nom);
            try {
                int degats = Integer.parseInt(textDegats.getText());
                if (degats > 100) {
                    // Afficher un message d'erreur si les dégâts dépassent 100
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Les degats ne peuvent pas depasser 100.");
                    alert.showAndWait();
                    return;
                }
                selectedArme.setDegats(degats);
            } catch (NumberFormatException e) {
                // Afficher un message d'erreur si les dégâts ne sont pas un nombre
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Le champ degats doit etre rempli et etre un nombre entier.");
                alert.showAndWait();
                return;
            }
            try {
                armeDao.mettreAJourArme(selectedArme);
                tableArmes.refresh();

                // Afficher une boîte de dialogue de confirmation
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Succes");
                alert.setHeaderText(null);
                alert.setContentText("L'arme a ete modifiee avec succes.");
                alert.showAndWait();
            } catch (IllegalArgumentException e) {
                // Afficher un message d'erreur pour les validations
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            // Afficher un message d'erreur si aucune arme n'est sélectionnée
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Aucune arme selectionnee pour la modification.");
            alert.showAndWait();
        }
    }
    /**
     * Aller à la liste des armes
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    private void goToListeArmes(ActionEvent event) throws IOException {
        // Charger le fichier FXML pour la liste des armes
        Parent root = FXMLLoader.load(getClass().getResource("/ListeArmes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
