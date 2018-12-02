package src.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import src.application.Main;
import src.models.User;
import src.models.daos.UserDAO;
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

/**
 * 
 * @author Andrécio Costa / Dante Alighieri
 * 
 */
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

    //Carrega os arquivos no banco 
    @FXML
    void actOk(ActionEvent event) {
    	// Validação dos campos, para verificação do preenchimento dos campos
    	if (validarArquivos()) {
	    	
	    	FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../views/MainScreen.fxml"));
			try {
				BorderPane mainScreen = (BorderPane) loader.load();
			
				Scene dados = new Scene(mainScreen);
				stage.setScene(dados);
				stage.setTitle("Inside Threat Project");
				//carrega os dados no banco
				carregarUsuarios();
				// mostra a próxima tela
				stage.show();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			finally {
				//encerra a tela atual
	    		stage = (Stage) btnOk.getScene().getWindow();
	    		stage.close();
	    	}
    	}
    	else {
    		//caso algum campo de endereço dos arquivos não preenchidos
    		lblNotice.setText("Indique o caminho de todos os arquivos!");
    	}

    }
    
    /*
     * Define o aplicativo de controle
     */
    public void setMainApp(Main main) {
		this.main = main;
	}
    
    /* Realiza a validaão dos campos, atestantando o preencimento dos mesmos */
    private boolean validarArquivos() {
    	if ((txtUsersFiles.getText().equals("")) || (txtDeviceFiles.getText().equals(""))||
      	(txtLogonFiles.getText().equals("")) || (txtDeviceFiles.getText().equals("")))
    		return false;
    	else
    		return true;
    }
    
    /* Realiza o carregamento dos dados no banco */
    private void carregarUsuarios() {
		List<String> lista;
		UserDAO userDao = new UserDAO();
    	try{
			BufferedReader leitor = new BufferedReader(new FileReader(txtUsersFiles.getText()));
			leitor.readLine(); //descarta a primeira linha
			String linha;
			int id = 1;
			while((linha = leitor.readLine()) != null) {
				lista = Arrays.asList(linha.split(","));
				User user = new User(id,lista.get(0),lista.get(3),lista.get(1),lista.get(4));
				userDao.save(user);
				id++;
			}
		}
    	catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	
    }
}