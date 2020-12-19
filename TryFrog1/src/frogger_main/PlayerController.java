package frogger_main;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * This class is responsible for  i/o of controlling the player
 *
 */
public class PlayerController{
	
	//movement animation images
		Image imgW1;
		Image imgA1;
		Image imgS1;
		Image imgD1;
		Image imgW2;
		Image imgA2;
		Image imgS2;
		Image imgD2;
		
		Image imgw;
		Image imga;
		Image imgs;
		Image imgd;
		
		int imgSize = 40;
		
		private boolean second = false;   //used to swap between moving animtion, can be handelled better
		double movement = 25;
		double movementX = 22;
		
		Player player;
		
		/**
		 * This method sets up the player model by defining all spirits required for movement
		 * @param player This is a passed reference of the player object
		 */
public PlayerController(Player player) {
	
	this.player=player;
	
	imgW1 = new Image("file:src/resources/froggerUp.png", imgSize, imgSize, true, true);
	imgA1 = new Image("file:src/resources/froggerLeft.png", imgSize, imgSize, true, true);
	imgS1 = new Image("file:src/resources/froggerDown.png", imgSize, imgSize, true, true);
	imgD1 = new Image("file:src/resources/froggerRight.png", imgSize, imgSize, true, true);
	imgW2 = new Image("file:src/resources/froggerUpJump.png", imgSize, imgSize, true, true);
	imgA2 = new Image("file:src/resources/froggerLeftJump.png", imgSize, imgSize, true, true);
	imgS2 = new Image("file:src/resources/froggerDownJump.png", imgSize, imgSize, true, true);
	imgD2 = new Image("file:src/resources/froggerRightJump.png", imgSize, imgSize, true, true);
	
	

	
}

/**
 * This method runs with the game timer and its in charge for checking keyboard input and arranging appropriate actions once input is detected
 * ands it changes Player spirits accordingly
 * since it is a constantly running function it also calls the checkintersections function
 * @see Player checkIntersections()
 */
public void checkcontrol() {
	player.checkIntersections();

	//System.out.println(points);
	player.setOnKeyPressed(new EventHandler<KeyEvent>() {  //when the key is first pressed
		public void handle(KeyEvent event){
			if (player.noMove) {
				
			}
			else {
			    if (second) {
			    	imgw=imgW1;
			    	imga=imgA1;
			    	imgs=imgS1;
			    	imgd=imgD1;
			    	 
			    }
			    else {
			    	imgw=imgW2;
			    	imga=imgA2;
			    	imgs=imgS2;
			    	imgd=imgD2;
			    }
			    
				if (event.getCode() == KeyCode.W) {	  
					player.move(0, -movement*2);
					player.setImage(imgw);
	                second = !second;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	player.move(-movementX*2, 0);
	            	player.setImage(imga);
	            	 second = !second;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	player.move(0, movement*2);
	            	player.setImage(imgs);
	            	 second = !second;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	player.move(movementX*2, 0);
	            	player.setImage(imgd);
	            	 second = !second;
	            }
			}	
		}
		});	
	player.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (player.noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (player.getY() < player.highestscore) {
						player.changeScore = true;
						
						player.highestscore = player.getY();
						player.points+=20;
					}
					player.setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	player.setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	player.setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	player.setImage(imgD1);
	            	 second = false;
	            }
	        }
			}

		
	});
}

	

}
