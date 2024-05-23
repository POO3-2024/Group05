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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur pour gérer les armes.
 */
public class ControleurArme {
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
    public void initialize() {
        armeDao = DaoFactory.getArmeDao();
        armes = FXCollections.observableArrayList(armeDao.obtenirToutesLesArmes());

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnDegats.setCellValueFactory(new PropertyValueFactory<>("degats"));

        tableArmes.setItems(armes);
    }

    /**
     * Supprime l'arme sélectionnée.
     *
     * @param event l'événement de clic
     */
    @FXML
    private void supprimerArme(ActionEvent event) {
        Arme selectedArme = tableArmes.getSelectionModel().getSelectedItem();
        if (selectedArme != null) {
            armeDao.supprimerArme(selectedArme.getId());
            armes.remove(selectedArme);
        }
    }
    /**
     * Navigue vers le menu principal.
     *
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    private void goToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Navigue vers l'interface d'ajout d'arme.
     *
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    private void goToAddArme(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AddArmes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Navigue vers l'interface de modification d'arme.
     *
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    void goToModifArmes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ModifArmes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
