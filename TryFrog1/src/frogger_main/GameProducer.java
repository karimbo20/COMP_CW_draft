package frogger_main;

import javafx.animation.AnimationTimer;

import javafx.stage.Stage; 
/**
 * This class handles all game related work
 * 
 */

public class GameProducer {
	public 
	MyStage background;
	Stage PS;
	public 
	Player player;
	SceneProducer sp;
	ScoreHandler ScH;
	obstacleFactory obstacle;
	
	AnimationTimer timer;
	
	PlayerController PC;
	
	/**
	 * the constructor gets reference to all necessary classes
	 * @param SP a reference to the SceneProducer which has all the references needed
	 */
	public GameProducer(SceneProducer sp) {
		this.background=sp.background;
		this.PS=sp.primaryStage;
		obstacle = new obstacleFactory();
		this.sp=sp;
		this.ScH=sp.ScH;
		
		start();
		
	}

	/**
	 * This function sets up the game scene 
	 * creates player object 
	 * created player controller and controls the player with it
	 * loads the music
	 * starts the timer
	 * gets the points 
	 * gets the highscore 
	 */
	public void start() {
		obstacle.addobjects(background);
		player=new Player();
    	background.addfront(player);
		PC=new PlayerController(player);
		background.playMusic();
    	createTimer();
    	obstacle.setNumber(player.getPoints(),false); 
    	obstacle.setNumber(ScH.gethighscore(),true);  
    	timer.start();
    }
	
	/**
	 * this method starts a game timer 
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
	 * This method works when the game ends and it stops the game then calls the next action(either to get next level or the win screen)
	 */
	private void StopFunctions() {
		background.lvl=background.lvl+1;
		background.stopMusic();
		background.stop();
		timer.stop();
		if (background.lvl<10) {
		sp.createnextlvlscrn();
		}
		else {sp.createwin();}
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


