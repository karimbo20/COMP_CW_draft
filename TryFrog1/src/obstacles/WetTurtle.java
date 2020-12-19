package obstacles;


import javafx.scene.image.Image;
import player_act.ActONTurtle;
import player_act.Actor;



/**
 * /**
 * This class defines wetTurtle function
 */

public class WetTurtle extends Actor{
	
	int pos=100;
	/**
	 * the constructor assigns images of the turtle and a type to be used to determine position
	 * @param s the speed of the object
	 */
	public WetTurtle( double s) {
		int temp=0;
		int ypos=0;
		int xpos=0;
		
		act=new ActONTurtle();
		//assign entity details
		image1 = new Image("file:src/resources/TurtleAnimation1.png", pos, pos, true, true);
		image2 = new Image("file:src/resources/TurtleAnimation2Wet.png", pos, pos, true, true);
		image3 = new Image("file:src/resources/TurtleAnimation3Wet.png", pos, pos, true, true);
		image4 = new Image("file:src/Images/TurtleAnimation4Wet.png", pos, pos, true, true);
		type="Turtle"+String.valueOf(s);
		
		if (s>0) {
			image1 = new Image("file:src/resources/TurtleAnimation1right.png", pos, pos, true, true);
			image2 = new Image("file:src/resources/TurtleAnimation2Wet.png", pos, pos, true, true);
			image3 = new Image("file:src/resources/TurtleAnimation3Wet.png", pos, pos, true, true);
		}
			
		if (temp!=0) {ypos=temp;}
			
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(image2);
	}
	
	/**
	 * checks if turtle is sunk or not 
	 * @return boolean whether the turtle is sunk or not
	 */
	public boolean isSunk() {
		return sunk;
	}
	/**
	 * method to retrieve speed of turtle
	 * @return double which is the speed of the turtle
	 */
	public double getspeed() {
		return speed;
	}
}

