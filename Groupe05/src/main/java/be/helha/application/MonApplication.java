package be.helha.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MonApplication extends Application {
	@Override
	public void start(Stage stage) {
		try {
			// Charger le fichier FXML pour le menu principal
			Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));
			// Créer une nouvelle scène avec la taille spécifiée
			Scene scene = new Scene(root, 800, 400);
			// Définir la scène pour la fenêtre
			stage.setScene(scene);
			// Définir le titre de la fenêtre
			stage.setTitle("Menu");
			// Afficher la fenêtre
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lance l'application JavaFX.
	 *
	 * @param args les arguments de la ligne de commande
	 */
	public static void lancer(String[] args) {
		// Démarre l'application JavaFX
		MonApplication.launch(args);
	}
}
