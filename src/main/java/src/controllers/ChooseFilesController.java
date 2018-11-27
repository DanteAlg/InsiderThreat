package src.controllers;

import java.io.File;
import java.io.IOException;

import src.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChooseFilesController {

	 Main main;
	 
	 private Stage stage = new Stage();
	 	 
	 @FXML
	 private AnchorPane chooseFiles;
	 
    @FXML
    private TextField txtUsersFiles;

    @FXML
    private TextField txtDeviceFiles;

    @FXML
    private TextField txtLogonFiles;

    @FXML
    private TextField txtHttpFiles;

    @FXML
    private Button btnUsersFiles;

    @FXML
    private Button btnDeviceFiles;

    @FXML
    private Button btnLogonFiles;

    @FXML
    private Button btnHttpFiles;

    @FXML
    private Button btnOk;
    
    @FXML
    private Label lblNotice;

    @FXML
    void actUsersFiles(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(stage);
		txtUsersFiles.setText(file.toString());		
    }
    	
    @FXML
    void actDeviceFiles(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(stage);
		txtDeviceFiles.setText(file.toString());		
    }

    @FXML
    void actHttpFiles(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(stage);
		txtHttpFiles.setText(file.toString());		
    }

    @FXML
    void actLogonFiles(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(stage);
		txtLogonFiles.setText(file.toString());		
    }

    @FXML
    void actOk(ActionEvent event) {
    	if (validarArquivos()) {
	    	
	    	FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../vision/MainScreen.fxml"));
			try {
				BorderPane mainScreen = (BorderPane) loader.load();
			
				Scene dados = new Scene(mainScreen);
				stage.setScene(dados);
				stage.setTitle("Reserva Já!");
				stage.show();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			finally {
	    		stage = (Stage) btnOk.getScene().getWindow();
	    		stage.close();
	    	}
    	}
    	else {
    		lblNotice.setText("Indique o caminho de todos os arquivos!");
    	}

    }

    public void setMainApp(Main main) {
		this.main = main;
	}
    
    private boolean validarArquivos() {
    	if ((txtUsersFiles.getText().equals("")) || (txtDeviceFiles.getText().equals(""))||
      	(txtLogonFiles.getText().equals("")) || (txtDeviceFiles.getText().equals("")))
    		return false;
    	else
    		return true;
    }
    

}
