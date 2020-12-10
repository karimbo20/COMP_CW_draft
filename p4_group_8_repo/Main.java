package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;


import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import p4_group_8_repo.structure.character.Player;
	public class Main extends Application {
		AnimationTimer timer;
		MyStage background;
		Player player;
		Level level;
		
		public static Stage BigStage;
		public static List<Stage>stageval = new ArrayList<Stage>();
		public static List<String>fxmlval = new ArrayList<String>();
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			this.BigStage = primaryStage;
			FXMLLoader xml = new FXMLLoader(getClass().getResource("Menu.fxml"));
			Pane root = (Pane)xml.load();
			primaryStage.setTitle("Frogger");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			

		}
	}