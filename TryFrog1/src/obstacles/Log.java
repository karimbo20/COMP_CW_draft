package obstacles;

import javafx.scene.image.Image;
import player_act.Actor;
import player_act.ActorMovement;

/**
 * This class defines the log function
 */

public class Log extends Actor {
	

	int dim=100;
	
	/**
	 * this method initiates log and sends it to world to check a free strip to place it on in the game using the checknextfree method
	 * @param imageLink the location of the log image
     * @param s the speed the log moves in
	 */
	public Log(String imageLink, double s) {
		act=new ActorMovement();
		
		int temp=0;
		int ypos=0;
		int xpos=0;
		setImage(new Image(imageLink, dim,dim, true, true));
		type="Log"+String.valueOf(s);
	
		if (temp!=0) {ypos=temp;}
			
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 * player uses this method o move alongside the log
	 * @return the speed of the log
	 */
	public double getspeed() {
		return speed;
	}
}