package be.helha.controleurs;

import be.helha.Personnage.Personnage;
import be.helha.dao.PersonnageDao;
import be.helha.daoimpl.DaoFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Controleur {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPv;
    @FXML
    private TextField txtManna;
    @FXML
    private TableView<Personnage> tableView;
    @FXML
    private TableColumn<Personnage, Integer> columnId;
    @FXML
    private TableColumn<Personnage, String> columnNom;
    @FXML
    private TableColumn<Personnage, Integer> columnPv;
    @FXML
    private TableColumn<Personnage, Integer> columnManna;

    private PersonnageDao personnageDao;

    public Controleur() {
        this.personnageDao = (PersonnageDao) DaoFactory.getInstance().getDaoImpl(PersonnageDao.class);

    }



    private void initialize() {
        // Configuration des colonnes du TableView
        List<Personnage> personnages = personnageDao.listerPersonnages();
        ObservableList<Personnage> personnageList = FXCollections.observableArrayList(personnages);

        columnId.setCellValueFactory(new PropertyValueFactory<Personnage, Integer>("id"));

        columnNom.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPv.setCellValueFactory(new PropertyValueFactory<>("pv"));
        columnManna.setCellValueFactory(new PropertyValueFactory<>("manna"));

        System.out.println(columnId);

        // Chargement initial des personnages
        tableView.setItems(personnageList);
    }

    private void listerPersonnage() {
        List<Personnage> personnages = personnageDao.listerPersonnages();
        ObservableList<Personnage> personnageList = FXCollections.observableArrayList(personnages);
        System.out.println(" AHHHHHHHHHHHHHHHHHHH"+ personnageList);

    }

    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goToMainMenu(ActionEvent event) throws IOException {
        navigateTo(event, "/MainMenu.fxml");
    }

    @FXML
    private void listerPersonnages(ActionEvent event) throws IOException {
        navigateTo(event, "/ListePersonnages.fxml");


    }

    @FXML
    private void goToListeArmes(ActionEvent event) throws IOException {
        navigateTo(event, "/ListeArmes.fxml");
    }

    @FXML
    private void goToModifPersonnages(ActionEvent event) throws IOException {
        navigateTo(event, "/ModifPersos.fxml");
    }

    @FXML
    private void goToModifArmes(ActionEvent event) throws IOException {
        navigateTo(event, "/ModifArmes.fxml");
    }

    @FXML
    private void goToAddArme(ActionEvent event) throws IOException {
        navigateTo(event, "/AddArmes.fxml");
    }

    private void navigateTo(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void suppressionPersonnage(ActionEvent event) {
        // Implémenter la logique de suppression de personnage
    }

    @FXML
    private void suppressionArme(ActionEvent event) {
        // Implémenter la logique de suppression d'arme
    }
}