package be.helha.controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur pour gérer la navigation entre les différentes scènes.
 */
public class Controleur {

    @FXML
    private void goToMainMenu(ActionEvent event) throws IOException {
        changeScene(event, "/fxml/MainMenu.fxml");
    }

    @FXML
    private void goToListeArmes(ActionEvent event) throws IOException {
        changeScene(event, "/fxml/ListeArmes.fxml");
    }

    @FXML
    private void goToAddArme(ActionEvent event) throws IOException {
        changeScene(event, "/fxml/AddArmes.fxml");
    }

    @FXML
    private void goToModifArmes(ActionEvent event) throws IOException {
        changeScene(event, "/fxml/ModifArmes.fxml");
    }

    private void changeScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
