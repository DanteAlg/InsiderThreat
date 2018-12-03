package src.controllers;

import src.models.Node;
import src.models.services.BuildForest;

import java.util.ArrayList;

import java.io.IOException;

import src.application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
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
	
	@FXML
	private ChoiceBox userSelect;


    /**
     *  Carrega a tela de seleção de usuários
     * @param event
     */
	/* Gera a árvore de usuários */
	@FXML
	void setBuildForest(ActionEvent event) {
		BuildForest b = new BuildForest(startDate.getText(), endDate.getText(), false);
		ArrayList<Node> forest = b.run();
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainScreenController.class.getResource("../views/ChooseUser.fxml"));
			AnchorPane chooseUserScreen = (AnchorPane) loader.load();
			ChooseUserController controle = new ChooseUserController();
			controle.loadUsers(forest);
			
			mainScreen.setCenter(chooseUserScreen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
  
}
