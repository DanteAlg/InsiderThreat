package src.application;

import java.io.IOException;

import src.controllers.ChooseFilesController;
import src.controllers.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * 
 * @author Andrécio Costa / Dante Alighieri
 *
 */
public class Main extends Application {

	private Stage primaryStage;
	public AnchorPane firstScreen;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Inside Threat Project");
		
		/*Carrega a cena*/
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/ChooseFiles.fxml"));
		firstScreen = (AnchorPane) loader.load();
		
		/*Mostra a cena*/
		Scene scene = new Scene(firstScreen);
		primaryStage.setScene(scene);
		primaryStage.show();

		ChooseFilesController controller = loader.getController();
		controller.setMainApp(this);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
