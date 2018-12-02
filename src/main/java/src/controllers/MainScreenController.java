package src.controllers;

import src.models.Node;
import src.models.services.BuildForest;

import java.util.ArrayList;

import java.io.IOException;

import src.application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import src.application.Main;
import javafx.event.ActionEvent;

/**
 * 
 * @author Andrécio Costa / Dante Alighieri
 *
 */
public class MainScreenController {

	private Main main;
	private Stage newStage = new Stage();

	@FXML
	private BorderPane mainScreen;

	@FXML
	private MenuItem menuPerfisUsuarios;

	@FXML
	private TextField startDate;

	@FXML
	private TextField endDate;

	@FXML
	private MenuItem menuRankUsuarios;

	@FXML
	private MenuItem menuUsuario;

	@FXML
	private MenuItem menuCategoria;

	/* Gera a árvore de usuários */
	@FXML
	void setBuildForest(ActionEvent event) {
		BuildForest b = new BuildForest(startDate.getText(), endDate.getText(), false);
		ArrayList<Node> forest = b.run();

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainScreenController.class.getResource("../views/ChooseUser.fxml"));
			AnchorPane chooseUserScreen = (AnchorPane) loader.load();
			
			mainScreen.setCenter(chooseUserScreen);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Tamanho da floresta de usuários: " + forest.size());
	}

	/* Carrega a tela de seleção do usuário (ChooseUser) */
	@FXML
	void actionMenuPerfisUsuarios(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainScreenController.class.getResource("../views/ChooseUser.fxml"));
			AnchorPane chooseUserScreen = (AnchorPane) loader.load();

			mainScreen.setCenter(chooseUserScreen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Carrega a tela de ranking dos usuários */
	@FXML
	void actionMenuRankUsuarios(ActionEvent event) {
		System.out.println("Menu Rank Usuarios ok");
	}

	@FXML
	void actionMenuUsuario(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainScreenController.class.getResource("../views/ChooseUser.fxml"));
			AnchorPane chooseUserScreen = (AnchorPane) loader.load();

			mainScreen.setCenter(chooseUserScreen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Carrega a tela de seleção do usuário (ChooseRole) */
	@FXML
	void actionMenuCategoria(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainScreenController.class.getResource("../views/ChooseRole.fxml"));
			AnchorPane chooseUserScreen = (AnchorPane) loader.load();

			mainScreen.setCenter(chooseUserScreen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
