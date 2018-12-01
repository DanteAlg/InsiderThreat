package src.controllers;

import java.io.IOException;

import src.application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.application.Main;
import javafx.event.ActionEvent;
/**
 * 
 * @author Andrécio Costa / Dante Alighieri
 *
 */
public class MainScreenController {
	
	Main main;
	private Stage newStage = new Stage();

    @FXML
    private BorderPane MainScreen;

    @FXML
    private MenuItem menuPerfisUsuarios;

    @FXML
    private MenuItem menuRankUsuarios;

    @FXML
    private MenuItem menuUsuario;

    @FXML
    private MenuItem menuCategoria;

      
    /* Carrega a tela de seleção do usuário (ChooseUser) */
    @FXML
    void actionMenuPerfisUsuarios(ActionEvent event) {
    	
    	try{
    		FXMLLoader loader = new FXMLLoader();
    	   	loader.setLocation(MainScreenController.class.getResource("../views/ChooseUser.fxml"));
    	   	AnchorPane chooseUserScreen = (AnchorPane) loader.load();
    	      	 	  	 
    	   	MainScreen.setCenter(chooseUserScreen);    	   	
    	}
    	catch(IOException e) {
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
    	try{
    		FXMLLoader loader = new FXMLLoader();
    	   	loader.setLocation(MainScreenController.class.getResource("../vision/ChooseUser.fxml"));
    	   	AnchorPane chooseUserScreen = (AnchorPane) loader.load();
    	      	 	  	 
    	   	MainScreen.setCenter(chooseUserScreen);    	   	
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }

    /* Carrega a tela de seleção do usuário (ChooseRole) */
    @FXML
    void actionMenuCategoria(ActionEvent event) {
    	try{
    		FXMLLoader loader = new FXMLLoader();
    	   	loader.setLocation(MainScreenController.class.getResource("../vision/ChooseRole.fxml"));
    	   	AnchorPane chooseUserScreen = (AnchorPane) loader.load();
    	      	 	  	 
    	   	MainScreen.setCenter(chooseUserScreen);    	   	
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }

}
