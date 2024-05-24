package be.helha.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MonApplication extends Application {
	@Override
	public void start(Stage stage) {
		try {
			stage.getIcons().add(new javafx.scene.image.Image("/img/Icon.png"));
			Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
			Scene scene = new Scene(root, 800, 400);
			stage.setScene(scene);
			stage.setTitle("Menu");
			stage.setOnCloseRequest(x -> Platform.exit());
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void lancer(String[] args) {
		MonApplication.launch(args);
	}
}
