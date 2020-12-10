package p4_group_8_repo.structure.obstacles;

import javafx.scene.image.Image;

public class WetTurtle extends Obstacle{
	
	
	private static int h = 130;
	private static int w = 130;
	
	static Image wetTurtle1 = new Image("file:src/p4_group_8_repo/assets/turtle/TurtleAnimation2Wet.png", w, h, true, true);
	static Image wetTurtle2 = new Image("file:src/p4_group_8_repo/assets/turtle/TurtleAnimation3Wet.png", w, h, true, true);
	static Image wetTurtle3 = new Image("file:src/p4_group_8_repo/assets/turtle/TurtleAnimation4Wet.png", w, h, true, true);
	
	boolean sunk;
	
	
	@Override
	public void act(long now) {
		if (now/900000000  % 4 ==0) {
			setImage(wetTurtle1);
			sunk = false;
			
		}
		else if (now/900000000 % 4 == 1) {
			setImage(Turtle.turtle1);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(wetTurtle2);
			sunk = false;
		} else if (now/900000000 %4 == 3) {
			setImage(wetTurtle3);
			sunk = true;
		}
	
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -75 && getSpeed()<0)
			setX(600);
		
	}
	
	public boolean isSunk() {
		return this.sunk;
	}
	
	public WetTurtle(int xpos, int ypos, double speed) {
		setX(xpos);
		setY(ypos);
		super.setSpeed(speed);
		setImage(Turtle.turtle1);
	}
	

}
