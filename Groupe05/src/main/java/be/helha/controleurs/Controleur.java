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

public class Controleur {

    public Label lblMenuTitle;
    @FXML
    private Label lblCharactDashBoTitle;

    @FXML
    private Button btnMainMenu;


    @FXML
    void goToListeArmes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ListeArmes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()) .getScene() .getWindow();
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void goToListePersos(ActionEvent event) throws IOException {
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

    public void goToModifArmes(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ModifArmes.fxml"));
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

    public void goToAddArme(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AddArmes.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()) .getScene() .getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void suppressionPersonnage(ActionEvent event) {
    }

    public void suppressionArme(ActionEvent event) {
    }
}
