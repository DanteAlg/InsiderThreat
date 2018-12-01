package src.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * 
 * @author Andrécio Costa / Dante Alighieri
 *
 */
public class ChooseRoleController {

    @FXML
    private AnchorPane chooseRole;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtRole;

    /* Retorna a tela anterior, fechando a atual*/
    @FXML
    void actionBtnCancelar(ActionEvent event) {
    	Stage stage = new Stage();
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("../vision/MainScreen.fxml"));
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

    /* Pesquisa a existência do usuário, se não houver avisa a não existência desse no cadastro */
    @FXML
    void actionBtnOk(ActionEvent event) {
    	txtRole.setText("");
    }

}
