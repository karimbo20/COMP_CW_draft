package p4_group_8_repo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MenuController{
	


    @FXML
    private Button startbutton;

    @FXML
    void startButtonClicked(ActionEvent event) throws IOException {
    	
    	Stage primaryStage = p4_group_8_repo.Main.BigStage;
    	Level level = new Level(primaryStage);
    	primaryStage.show();
    	 
    }
    
    @FXML
    void helpButtonClicked(ActionEvent event) throws IOException{
    	Parent helpFXML = FXMLLoader.load(getClass().getResource("help.fxml"));
		Scene helpView = new Scene(helpFXML);
		
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(helpView);
		window.show();
    }
    
    @FXML
    void backButtonClicked(ActionEvent event) throws IOException {
    	Parent backfxml = FXMLLoader.load(getClass().getResource("Menu.fxml"));
    	Scene menu = new Scene(backfxml);
    	Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
    	window.setScene(menu);
    	window.show();
    }

}