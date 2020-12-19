package digits;

import frogger_main.Player;
import javafx.scene.image.Image;
import player_act.Actor;
import player_act.ActorMovement;


/**
 * This class is used for the end holes and has no runtime functionality
 * @author khaled
 *
 */
public class End extends Actor{
	boolean activated = false;
	int dim=70;
	int ypos=92;
	int xpos[]= {10,120,250,360};
	static int i=0;
	
	/**
	 * The constructor initiaites the functionality and has an array that stores the positions that each hole should be in
	 */
	public End() {  //initialize end hole 
		
		act=new ActorMovement();
		
		setX(xpos[i]);
		setY(ypos);
		i++;
		if(i==5) {i=0;}
		setImage(new Image("file:src/resources/End.png", dim, dim, true, true));
	}
	
	/**
	 * used to trigger the hole once the player has reached it
	 */
	public void setEnd() { //add frog image to indicate it triggered
		setImage(new Image("file:src/resources/FrogEnd.png",dim, dim, true, true));
		activated = true;
	}
	
	 
	/**
	 * used to check if the hole has been activated
	 * @return a boolean indicating if the hole has been activated or not
	 */
	public boolean isActivated() { //tells other classes if hole is activated or not
		return activated;
	}

	

}
