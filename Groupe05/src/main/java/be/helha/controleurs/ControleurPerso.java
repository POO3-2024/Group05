package be.helha.controleurs;

import be.helha.Personnage.Personnage;
import be.helha.dao.PersonnageDao;
import be.helha.daoimpl.DaoFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControleurPerso implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configuration des colonnes du TableView

        columnId.setCellValueFactory(new PropertyValueFactory<Personnage, Integer>("id"));

        columnNom.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnPv.setCellValueFactory(new PropertyValueFactory<>("pv"));
        columnManna.setCellValueFactory(new PropertyValueFactory<>("manna"));

        System.out.println(columnId);
listerPersonnage();

    }

    private void listerPersonnage() {
        this.personnageDao = (PersonnageDao) DaoFactory.getInstance().getDaoImpl(PersonnageDao.class);

        List<Personnage> personnages = personnageDao.listerPersonnages();
        ObservableList<Personnage> personnageList = FXCollections.observableArrayList(personnages);
        System.out.println(" AHHHHHHHHHHHHHHHHHHH"+ personnageList);
        // Chargement initial des personnages
        tableView.setItems(personnageList);

    }

    /**
     * Gère l'ajout d'un nouveau personnage.
     *
     * @param event L'événement d'action déclenché par l'utilisateur.
     * @throws IOException En cas d'erreur de navigation.
     */
    @FXML
    private void ajouterPersonnage(ActionEvent event) throws IOException {
        navigateTo(event, "/AddPersos.fxml");
    }


    @FXML
    private void goToMainMenu(ActionEvent event) throws IOException {
        navigateTo(event, "/MainMenu.fxml");
    }

    @FXML
    private void listerPersonnages(ActionEvent event) throws IOException {
        navigateTo(event, "/ListePersonnages.fxml");


    }

    private void navigateTo(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}




