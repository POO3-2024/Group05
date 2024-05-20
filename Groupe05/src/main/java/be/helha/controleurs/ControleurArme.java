// src/main/java/be/helha/controleurs/ControleurArme.java
package be.helha.controleurs;

import be.helha.dao.ArmeDao;
import be.helha.daoimpl.ArmeDaoImpl;
import be.helha.domaine.Arme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

/**
 * Contrôleur pour la gestion des armes.
 */
public class ControleurArme {
    private ArmeDao armeDao = new ArmeDaoImpl();

    @FXML
    private TableView<Arme> tableViewArmes;
    @FXML
    private TableColumn<Arme, Integer> columnId;
    @FXML
    private TableColumn<Arme, String> columnNom;
    @FXML
    private TableColumn<Arme, Integer> columnDegats;
    @FXML
    private TextField textFieldNom;
    @FXML
    private TextField textFieldDegats;

    /**
     * Initialise le contrôleur en affichant toutes les armes.
     */
    public void initialize() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnDegats.setCellValueFactory(new PropertyValueFactory<>("degats"));
        afficherToutesLesArmes();
    }

    /**
     * Affiche toutes les armes dans la table view.
     */
    @FXML
    private void afficherToutesLesArmes() {
        List<Arme> armes = armeDao.obtenirToutesLesArmes();
        ObservableList<Arme> observableArmes = FXCollections.observableArrayList(armes);
        tableViewArmes.setItems(observableArmes);
    }

    /**
     * Ajoute une nouvelle arme à la base de données et met à jour la table view.
     */
    @FXML
    private void ajouterArme() {
        String nom = textFieldNom.getText();
        int degats = Integer.parseInt(textFieldDegats.getText());
        Arme arme = new Arme(nom, degats);
        armeDao.ajouterArme(arme);
        afficherToutesLesArmes();
    }

    /**
     * Supprime l'arme sélectionnée de la base de données et met à jour la table view.
     */
    @FXML
    private void supprimerArme() {
        Arme arme = tableViewArmes.getSelectionModel().getSelectedItem();
        if (arme != null) {
            armeDao.supprimerArme(arme.getId());
            afficherToutesLesArmes();
        }
    }

    /**
     * Met à jour une arme existante dans la base de données et met à jour la table view.
     */
    @FXML
    private void mettreAJourArme() {
        Arme arme = tableViewArmes.getSelectionModel().getSelectedItem();
        if (arme != null) {
            String nom = textFieldNom.getText();
            int degats = Integer.parseInt(textFieldDegats.getText());
            arme.setNom(nom);
            arme.setDegats(degats);
            armeDao.mettreAJourArme(arme);
            afficherToutesLesArmes();
        }
    }

    /**
     * Sélectionne une arme dans la table view pour la mise à jour.
     */
    @FXML
    private void selectionnerArme() {
        Arme arme = tableViewArmes.getSelectionModel().getSelectedItem();
        if (arme != null) {
            textFieldNom.setText(arme.getNom());
            textFieldDegats.setText(String.valueOf(arme.getDegats()));
        }
    }
}
