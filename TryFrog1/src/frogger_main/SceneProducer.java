package frogger_main;
import javafx.animation.AnimationTimer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import java.util.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class handles all scene related work 
 * 
 *
 */
public class SceneProducer {


	public Scene menuscene,infoscene;

	int xres=500;
	int yres=800;


	String name;

	Scene gamescene;

	public Stage primaryStage;
	public MyStage background;
	GameProducer GP;
	public ScoreHandler ScH;

	Scene back;

	//private TableView table;

	AnimationTimer timer;

	public MyStage stage;

	/**
	 * The constructor instantiates all nessecary objects for the scenes and sets the menu scene to display
	 * @param PrimaryStage This is the base scene which is used to change what is displayed
	 */
	public SceneProducer(Stage PrimaryStage) {
		this.primaryStage=PrimaryStage;
		primaryStage.setResizable(false);


		ScH=new ScoreHandler();

		menuscene = CreateMenu();
		infoscene=CreateInfo();

		primaryStage.setScene(CreateMenu());
		primaryStage.setTitle("FROGGER");
		primaryStage.show();
		primaryStage.getIcons().add(new Image("file:src/resources/smiiling-big-eyed-green-frog-clipart-6926.jpg"));
	}

	/**
	 * This function is called to create the menu scene
	 * @return A reference to the menu scene that can be used to set the primary stage to
	 */
	private Scene CreateMenu() {


		Image logo=new Image("file:src/resources/froggerlogo.png", 350, 350, true, true);
		ImageView iv1 = new ImageView();
		iv1.setImage(logo);



		Label label1=new Label("Vintage Game");
		label1.setFont(new Font("Comic Sans MS", 35));
		label1.setStyle("-fx-text-fill: #00ff00;-fx-color:Green");

		Label label2=new Label("Created By Karim Fadl");
		label2.setFont(new Font("Comic Sans MS", 35));
		label2.setStyle("-fx-text-fill: #00ff00;-fx-color:Green");





		Button button1=new Button("PLAY");
		button1.setFont(new Font("Comic Sans MS", 20));
		button1.setOnAction(e -> primaryStage.setScene(creategamescene()));
		button1.setMinSize(100, 50);
		button1.setStyle("-fx-text-fill: #000000;-fx-background-color:Green");
		
		Button button2=new Button("Scoreboard");
		button2.setOnAction(e -> primaryStage.setScene(createtable()));
		button2.setMinSize(100, 50);
		button2.setFont(new Font("Comic Sans MS", 20));
		button2.setStyle("-fx-text-fill: #000000;-fx-background-color:Green");

		Button button3=new Button("info");
		button3.setOnAction(e -> primaryStage.setScene(infoscene));
		button3.setMinSize(100, 50);
		button3.setFont(new Font("Comic Sans MS", 20));
		button3.setStyle("-fx-text-fill: #000000;-fx-background-color:Green");

		
		
		Button button4=new Button("Exit");
		button4.setOnAction(e -> primaryStage.close());
		button4.setMinSize(100, 50);
		button4.setFont(new Font("Comic Sans MS", 20));
		button4.setStyle("-fx-text-fill: #000000;-fx-background-color:Green");


		VBox layout1=new VBox();         
		layout1.setSpacing(50);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(iv1,label1,label2,button1,button2,button3,button4);
		layout1.setStyle("-fx-background-color: #000000;");
		layout1.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), CornerRadii.EMPTY, Insets.EMPTY)));
		Scene menuscene=new Scene(layout1,xres,yres);
		back=menuscene;
		return menuscene;
	}

	/**
	 * This method is used to create an info screen scene
	 * @return a reference to the info for screen scene to set the primary stage to
	 */
	private Scene CreateInfo() {
		Button button1=new Button("Return");
		button1.setOnAction(e -> primaryStage.setScene(menuscene));
		button1.setFont(new Font("Comic Sans MS", 20));
		button1.setMinSize(100, 50);
		button1.setStyle("-fx-text-fill: #0000ff;-fx-background-color:White");

		Image wasd=new Image("file:src/resources/wasd.png", 150, 150, true, false);
		ImageView iv1 = new ImageView();
		iv1.setImage(wasd);


		Image arcade=new Image("file:src/resources/arcade.png", 225, 225, true, false);
		ImageView iv2 = new ImageView();
		iv2.setImage(arcade);

		Label label1=new Label("GOAL: REACH THE END IF YOU CAN \n To reach the end you have to pass through various\n obsticals with difffrent speeds and shapes.");
		label1.setFont(new Font("Comic Sans MS", 15));




		Label label2=new Label("CONTROLS");
		label2.setFont(new Font("Comic Sans MS", 32));

		Label label3=new Label("You will use W,D,S,A to control the player in the game.\n W= Move forward \n A= Move to the right \n S= Move down \n D= Move to the left\n Their is multiple levels waiting to be completed\n");
		label3.setFont(new Font("Comic Sans MS", 15));




		VBox layout2=new VBox();         
		layout2.getChildren().addAll(label1,iv2,label2,label3,iv1,button1);
		layout2.setSpacing(50);
		layout2.setBackground(new Background(new BackgroundFill(Color.rgb(0, 128, 128), CornerRadii.EMPTY, Insets.EMPTY)));
		layout2.setAlignment(Pos.CENTER);// Changed the alignment to center-left
		return(new Scene(layout2,xres,yres));
	}

	/**
	 * This method creates the game scene and starts everything required for the game to run
	 * @return  A reference to the game scene that the primary stage can be set to
	 */
	Scene creategamescene() {
		background = new MyStage(); //Mystage is the application window
		Scene scene  = new Scene(background,xres,yres); //creates new scene with background as root node	    
		background.start();

		GP=new GameProducer(this); 
		return(scene);
	}

	/**
	 * This method creates a scene with a table that shows the highest 10 scores of previous players
	 * @return a reference to the table scene that the primary stage can be set to
	 */
	public Scene createtable() {
		TableView table = new TableView();
		table.setMaxSize(300, 400);
		ArrayList scores=new ArrayList(ScH.getscore());

		TableColumn<Score,String> namecol = new TableColumn<>("name");
		TableColumn<Score,String> scorecol = new TableColumn<>("Score");
		TableColumn<Score,String> lvlcol = new TableColumn<>("Level");
		scorecol.setSortType(TableColumn.SortType.DESCENDING);
		table.setFixedCellSize(30);
		table.setEditable(false);
		namecol.setMinWidth(100);
		scorecol.setMinWidth(100);
		lvlcol.setMinWidth(100);


		namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
		scorecol.setCellValueFactory(new PropertyValueFactory<>("Score"));
		lvlcol.setCellValueFactory(new PropertyValueFactory<>("Level"));

		for(int j=0;j<scores.size();j++) {
			if(j<=10) {
				table.getItems().add(scores.get(j));
			}
		}

		table.getColumns().addAll(namecol,scorecol,lvlcol);
		table.getSortOrder().add(scorecol);

		Button button1=new Button("Back");
		button1.setOnAction(e -> primaryStage.setScene(back));
		button1.setMinSize(100, 50);
		button1.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");


		VBox layout2=new VBox();         
		layout2.getChildren().addAll(table,button1);
		layout2.setSpacing(50);
		layout2.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), CornerRadii.EMPTY, Insets.EMPTY)));
		layout2.setAlignment(Pos.CENTER);// Changed the alignment to center-left
		return(new Scene(layout2,xres,yres));

	}

	/**
	 * This method creates and sets a win screen for the player that appears when the player completes 10 levels
	 */
	public void createwin() {

		Label label1=new Label("");
		if(ScH.getPoints()>ScH.gethighscore()) {
			label1=new Label("NEW HIGH SCORE!");
		}
		label1.setFont(new Font("Comic Sans MS", 20));


		Label label2=new Label("YOU WIN.");
		label2.setFont(new Font("Comic Sans MS", 20));

		Label label3=new Label("Score: "+ScH.getPoints());
		label3.setFont(new Font("Comic Sans MS", 20));


		TextField textField = new TextField();
		textField.setMaxSize(150, 50);
		Button button1 = new Button("Submit Name");
		button1.setFont(new Font("Comic Sans MS", 20));
		button1.setMinSize(100, 50);
		button1.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		button1.setOnAction(action -> {ScH.writescores(textField.getText(),ScH.getPoints(),background.lvl);});

		Button button2=new Button("Scoreboard");
		button2.setFont(new Font("Comic Sans MS", 20));
		button2.setOnAction(e -> primaryStage.setScene(createtable()));
		button2.setMinSize(100, 50);
		button2.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");

		Button button3=new Button("Exit");
		button3.setFont(new Font("Comic Sans MS", 20));
		button3.setOnAction(e -> primaryStage.close());
		button3.setMinSize(100, 50);
		button3.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");

		VBox layout1=new VBox();         
		layout1.setSpacing(50);
		layout1.setAlignment(Pos.CENTER);// Changed the alignment to center-left
		layout1.getChildren().addAll(label1,label2,label3,textField,button1,button2,button3);
		layout1.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), CornerRadii.EMPTY, Insets.EMPTY)));
		Scene winscene=new Scene(layout1,xres,yres);
		back=winscene;
		primaryStage.setScene(winscene);
	}

	/**
	 * This method creates and sets a scene between levels, it is similar to the win screen but has the ability to proceed to the next level
	 */
	public void createnextlvlscrn() {



		background.removeall();

		Label label1=new Label("LEVEL "+background.lvl+"!");
		label1.setFont(new Font("Comic Sans MS", 20));

		Label label2=new Label("Score: "+ScH.getPoints());
		label1.setFont(new Font("Comic Sans MS", 20));

		Button button1=new Button("Next Level");
		button1.setFont(new Font("Comic Sans MS", 20));
		button1.setOnAction(e -> primaryStage.setScene(creategamescene()));
		button1.setMinSize(100, 50);
		button1.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");

		Button button2=new Button("Scoreboard");
		button2.setFont(new Font("Comic Sans MS", 20));
		button2.setOnAction(e -> primaryStage.setScene(createtable()));
		button2.setMinSize(100, 50);
		button2.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");

		Button button3=new Button("Exit");
		button3.setFont(new Font("Comic Sans MS", 20));
		button3.setOnAction(e -> primaryStage.close());
		button3.setMinSize(100, 50);
		button3.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");

		TextField textField = new TextField();
		textField.setMaxSize(150, 50);

		Button button4 = new Button("Submit Name");
		button4.setFont(new Font("Comic Sans MS", 20));
		button4.setMinSize(100, 50);
		button4.setStyle("-fx-text-fill: #00ff00;-fx-background-color:Green");
		button4.setOnAction(action -> {
			ScH.writescores(textField.getText(),ScH.getPoints(),background.lvl);
		}
				)
		;

		VBox layout1=new VBox();         
		layout1.setSpacing(50);
		layout1.setAlignment(Pos.CENTER);// Changed the alignment to center-left
		layout1.getChildren().addAll(label1,label2,textField,button1,button2,button3,button4);
		layout1.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0), CornerRadii.EMPTY, Insets.EMPTY)));
		Scene nxtlvlscene=new Scene(layout1,xres,yres);
		back=nxtlvlscene;
		primaryStage.setScene(nxtlvlscene);
	}

}