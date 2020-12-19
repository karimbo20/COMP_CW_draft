package frogger_main;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

/**
 * This class is in charge of the game session
 * It starts and ends the game session
 *
 */
public class GameHandler {
	
	public MyStage background;
	Stage PS;
	public Player player;
    obstacleFactory obstacle;
	SceneProducer SP;
	ScoreHandler ScH;
	AnimationTimer timer;
	PlayerController PC;
	/**
	 * the constructor gets reference to all necessary classes
	 * @param SP a reference to the SceneProducer which has all the references needed
	 */
	public GameHandler(SceneProducer SP) {
		this.background=SP.background;
		this.PS=SP.primaryStage;
		obstacle = new obstacleFactory();
		this.SP=SP;
		this.ScH=SP.ScH;
		
		start();
		
	}

	/**
	 * This sets up the game scene it does the following tasks:
	 * creates player object 
	 * created player controller and attaches the player to it
	 * starts the music timer
	 * adds the initial score and highscore
	 */
	public void start() {
		obstacle.addobjects(background);
		player=new Player();
    	background.addfront(player);
		PC=new PlayerController(player);
		background.playMusic();
    	createTimer();
    	obstacle.setNumber(ScH.gethighscore(),true);  
    	obstacle.setNumber(player.getPoints(),false);  
        timer.start();
    }
	
	/**
	 * This method starts a game timer for player related functions
	 */
	private void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	PC.checkcontrol();
            	if (player.changeScore()) {  //if theres been a change in teh score
            		obstacle.setNumber(player.getPoints(),false);  
            		}
            	if (checkends()) { //stops everything and alerts player if all 5 ends are filled
            		StopFunctions();
            	}
            }

			
        };
    }
	
	/**
	 * This method runs when the game ends and it stops all game functions from living and calls the next action(either to get next level or the win screen)
	 */
	private void StopFunctions() {
		background.lvl=background.lvl+1;
		background.stopMusic();
		background.stop();
		timer.stop();
		if (background.lvl<10) {
		SP.createnextlvlscrn();
		}
		else {SP.createwin();}
	}
	
	/**
	 * This function runs to check that all end holes have been activated
	 * @return true of all holes have been activated, false otherwise
	 */
	private boolean checkends() {
		for(int i=0;i<obstacle.ends.size();i++) {
		if(!obstacle.ends.get(i).isActivated()) {
			return(false);
		}
		}
		return(true);
	}
	
}