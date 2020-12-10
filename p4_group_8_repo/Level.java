package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;
import p4_group_8_repo.structure.obstacles.Obstacle;
import p4_group_8_repo.structure.obstacles.Position;
import p4_group_8_repo.structure.character.Player;

public class Level {
	
	static AnimationTimer timer;
	static MyStage backgroud;
	static Player player;
	
	public Level(Stage primaryStage) {
		MyStage background = new MyStage();
		Scene scene = new Scene(background, 600, 750);

		
		BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/assets/background.png");

		background.add(froggerback);

		Position pos = new Position();
		
		
		// row1
		Obstacle logR1 = pos.getObstacle("log", 0, 166, 0.75, false);
		Obstacle logR2 = pos.getObstacle("log", 220, 166, 0.75, false);
		Obstacle logR3 = pos.getObstacle("log", 440, 166, 0.75, false);
		// row2
		Obstacle logL1 = pos.getObstacle("log", 0, 276, -2, true);
		Obstacle logL2 = pos.getObstacle("log", 400, 276, -2, true);
		// row3
		Obstacle logR4 = pos.getObstacle("log", 50, 329, 0.75, false);
		Obstacle logR5 = pos.getObstacle("log", 270, 329, 0.75, false);
		Obstacle logR6 = pos.getObstacle("log", 490, 329, 0.75, false);

		background.add(logR1);
		background.add(logR2);
		background.add(logR3);
		background.add(logR4);
		background.add(logR5);
		background.add(logR6);

		background.add(logL1);
		background.add(logL2);

		Obstacle tur1 = pos.getObstacle("turtlefloat", 500, 376, -1, false);
		Obstacle tur2 = pos.getObstacle("turtlefloat", 300, 376, -1, false);
		Obstacle tur3 = pos.getObstacle("wetturtle", 700, 376, -1, false);
		Obstacle tur4 = pos.getObstacle("wetturtle", 600, 217, -1, false);
		Obstacle tur5 = pos.getObstacle("wetturtle", 400, 217, -1, false);
		Obstacle tur6 = pos.getObstacle("wetturtle", 200, 217, -1, false);
		
		background.add(tur1);
		background.add(tur2);
		background.add(tur3);
		background.add(tur4);
		background.add(tur5);
		background.add(tur6);
		
		background.add(new End(13, 96));
		background.add(new End(141, 96));
		background.add(new End(141 + 141 - 13, 96));
		background.add(new End(141 + 141 - 13 + 141 - 13 + 1, 96));
		background.add(new End(141 + 141 - 13 + 141 - 13 + 141 - 13 + 3, 96));
		player = new Player("file:src/p4_group_8_repo/assets/frogger/froggerUp.png");

		background.add(player);
		
		Obstacle truck1 = pos.getObstacle("truck", 0, 649, 1, false);
		Obstacle truck2 = pos.getObstacle("truck", 300, 649, 1, false);
		Obstacle truck3 = pos.getObstacle("truck", 600, 649, 1, false);
		
		Obstacle truck4 = pos.getObstacle("truck", 0, 540, 1, true);
		Obstacle truck5 = pos.getObstacle("truck", 500, 540, 1, true);
		
		background.add(truck1);
		background.add(truck2);
		background.add(truck3);
		background.add(truck4);
		background.add(truck5);
		
		Obstacle car1 = pos.getObstacle("car", 250, 597, -1, false);
		Obstacle car2 = pos.getObstacle("car", 400, 597, -1, false);
		Obstacle car3 = pos.getObstacle("car", 550, 597, -1, false);
		Obstacle fastcar = pos.getObstacle("car", 500, 490, -5, false);
		
		background.add(car1);
		background.add(car2);
		background.add(car3);
		background.add(fastcar);
		background.add(new Digit(0, 30, 360, 25));
		 
		// background.add(obstacle);
		// background.add(obstacle1);
		// background.add(obstacle2);
		background.start();
		primaryStage.setScene(scene);
		//primaryStage.show();
		Score.startScore();
		// background music is muted
		background.mute(true);
	}
}