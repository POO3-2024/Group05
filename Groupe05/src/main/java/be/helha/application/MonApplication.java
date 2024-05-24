package be.helha.application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;



public class MonApplication extends Application {
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
	@FXML
	private Button btnMainArmes;

	@FXML
	private Button btnMainPersos;

	@FXML
	private Label lblMainMenu;

	@FXML
	private void goToListeArmes(ActionEvent event) throws IOException {
		System.out.println("goToListeArmes called");
		Parent root = FXMLLoader.load(getClass().getResource("/ListeArmes.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}


	@FXML
	void goToListePersos(ActionEvent event) {

	}

	public static void lancer(String[] args) {
		MonApplication.launch(args);
	}

}

