package controleurs;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControleurArme {


    public void OnClic(ActionEvent event) {
        //*Passe à l'écran suivant*
        try {

            Stage stage = new Stage();
            stage.getIcons().add(new javafx.scene.image.Image("/Icon.png"));
            Parent root = FXMLLoader.load(getClass().getResource("/Vue2.fxml"));
            Scene scene = new Scene(root,500,400);
            stage.setScene(scene);
            stage.setTitle("Screen1");
            stage.setOnCloseRequest(x-> Platform.exit());
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
