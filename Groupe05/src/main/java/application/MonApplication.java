package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;


public class MonApplication extends Application {
	@Override
	public void start(Stage stage) {
		try {

			stage.getIcons().add(new javafx.scene.image.Image("/Icon.png"));
			Parent root = FXMLLoader.load(getClass().getResource("/Vue.fxml"));
			Scene scene = new Scene(root,500,400);
			stage.setScene(scene);
			stage.setTitle("Menu");
			stage.setOnCloseRequest(x->Platform.exit());
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void lancer(String[] args) {
		MonApplication.launch(args);
	}

}
