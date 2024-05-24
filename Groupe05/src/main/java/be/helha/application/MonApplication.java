package be.helha.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MonApplication extends Application {

	/**
	 *
	 * @param stage the primary stage for this application, onto which
	 * the application scene can be set.
	 * Applications may create other stages, if needed, but they will not be
	 * primary stages.
	 */
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
			Scene scene = new Scene(root, 800, 400);
			stage.setScene(scene);
			stage.setTitle("Menu");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void lancer(String[] args) {
		MonApplication.launch(args);
	}

}

