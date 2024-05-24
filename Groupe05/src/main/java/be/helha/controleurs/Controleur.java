package be.helha.controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controleur {
    @FXML
    private Button btnMainMenu;

    @FXML
    private TableView<?> tableArmes;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnNom;

    @FXML
    private TableColumn<?, ?> columnDegats;


    public Label lblMenuTitle;
    @FXML
    private Label lblCharactDashBoTitle;

    @FXML
    public void goToListePersos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ListePersonnages.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()) .getScene() .getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void goToMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/mainMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()) .getScene() .getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void goToModifPersonnages(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ModifPersos.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()) .getScene() .getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void goToAddPersos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AddPersos.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()) .getScene() .getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void suppressionPersonnage(ActionEvent event) {
    }


}