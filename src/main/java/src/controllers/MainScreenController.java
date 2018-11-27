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

    @FXML
    private MenuItem menuSobre;

    
   
    @FXML
    void actionMenuPerfisUsuarios(ActionEvent event) {
    	
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

    @FXML
    void actionMenuSobre(ActionEvent event) {
    	System.out.println("Menu Sobre ok");
    }

}
