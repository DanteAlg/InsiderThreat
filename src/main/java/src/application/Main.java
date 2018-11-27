package src.application;

import java.io.IOException;

import src.controllers.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	public BorderPane mainscreen;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Inside Threat Project");
		
		/*Carrega a cena*/
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/MainScreen.fxml"));
		mainscreen = (BorderPane) loader.load();
		
		/*Mostra a cena*/
		Scene scene = new Scene(mainscreen);
		primaryStage.setScene(scene);
		primaryStage.show();

		MainScreenController controller = loader.getController();
		controller.setMainApp(this);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
