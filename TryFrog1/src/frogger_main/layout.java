package frogger_main;

import javafx.scene.image.Image;
import player_act.Actor;
import player_act.ActorMovement;

/**
 * This class is used for the layout of the score and highscore at the top of the screen and has no runtime functionality 
 */
public class layout extends Actor{

	int dim=100; //dimensions
	Image im1;
	
	/**
	 * This method is used for the highscore and score layout at the top of the screen and has no runtime functionality 
	 *
	 */
	public layout(String imageLink,int dim, int xpos,int ypos) {
		
		act=new ActorMovement();
		
		setImage(new Image(imageLink, dim,dim, true, true));
		setX(xpos);
		setY(ypos);
	}

}
