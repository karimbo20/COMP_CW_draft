package obstacles;


import javafx.scene.image.Image;
import player_act.ActONTurtle;
import player_act.Actor;

/**
 * This class defines the Turtle function
 */
public class Turtle extends Actor{
	
	int dim=100;
	
	/**
	 * the constructor assigns images of the turtle and a type to be used to determine position
	 * @param s the speed of the object
	 */
	public Turtle(double s) {
		int temp=0;
		int ypos=0;
		int xpos=0;
		
		act=new ActONTurtle(); // player act on Turtle
		
		//import turtle 
		
		image1 = new Image("file:src/resources/TurtleAnimation1.png", dim, dim, true, true);
		image2 = new Image("file:src/resources/TurtleAnimation2.png", dim, dim, true, true);
		image3 = new Image("file:src/resources/TurtleAnimation3.png", dim, dim, true, true);
		image4 = null;
		type="Turtle"+String.valueOf(s);
		
		if (s>0) {
			
	
			image1 = new Image("file:src/resources/TurtleAnimation1mirror.png", dim, dim, true, true);
			image2 = new Image("file:src/resources/TurtleAnimation2mirror.png", dim, dim, true, true);
			image3 = new Image("file:src/resources/TurtleAnimation3mirror.png", dim, dim, true, true);
			
			
		}
		
		
	
		if (temp!=0) {ypos=temp;}
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(image2);
	}
	
	/**
	 * Player uses this to move alongside the turtle
	 * @return  speed of the turtle
	 */
	public double getspeed() {
		return speed;
	}

}