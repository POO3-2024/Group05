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
 * Contrôleur pour modifier une arme.
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

        System.out.println("TableView tableArmes: " + (tableArmes != null));
        System.out.println("Colonnes: " + tableArmes.getColumns().size());
    }

    /**
     * Met à jour l'arme sélectionnée.
     *
     * @param event l'événement de clic
     */
    @FXML
    private void mettreAJourArme(ActionEvent event) {
        System.out.println("Méthode mettreAJourArme appelée.");
        Arme selectedArme = tableArmes.getSelectionModel().getSelectedItem();
        System.out.println("Selected Arme: " + (selectedArme != null));
        if (selectedArme != null) {
            selectedArme.setNom(textNom.getText());
            try {
                selectedArme.setDegats(Integer.parseInt(textDegats.getText()));
            } catch (NumberFormatException e) {
                System.err.println("Entrée invalide pour les dégâts : " + textDegats.getText());
                return;
            }
            armeDao.mettreAJourArme(selectedArme);
            tableArmes.refresh();
        } else {
            System.err.println("Aucune arme sélectionnée pour la mise à jour.");
        }
    }

    /**
     * Navigue vers la liste des armes.
     *
     * @param event l'événement de clic
     * @throws IOException si une erreur d'I/O survient
     */
    @FXML
    private void goToListeArmes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ListeArmes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
