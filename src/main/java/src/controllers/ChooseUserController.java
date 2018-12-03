package src.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.models.Node;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
/**
 * 
 * @author Andrecio Costa / Dante Alighieri
 *
 */
public class ChooseUserController {

    @FXML
    private AnchorPane ChooseUser;
    
    @FXML
    private ChoiceBox<String> userSelect;
    
    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancelar;
    
    /**
     * Pesquisa a existência do usuario, se não houver avisa a não existência desse no cadastro
     * @param event
     */
    @FXML
    void actionBtnOk(ActionEvent event) {
    	
    }

    /**
     *  Retorna a tela anterior, fechando a atual
     * @param event
     */
    @FXML
    void actionBtnCancelar(ActionEvent event) {
    	Stage stage = new Stage();
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("../views/MainScreen.fxml"));
    	    Scene previous = new Scene(root);
    		stage.setScene(previous);
    		stage.setTitle("Inside Threat Project");
    		stage.show();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	finally {
    		stage = (Stage) btnCancelar.getScene().getWindow();
    		stage.close();
    	}
    }
    
    public void carregarUsuarios(ArrayList<Node> forest) {
    	String teste = "teste";
    	userSelect.getItems().add(teste);
    }
}
