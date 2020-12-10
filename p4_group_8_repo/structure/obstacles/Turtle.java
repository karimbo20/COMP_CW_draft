package p4_group_8_repo.structure.obstacles;

import javafx.scene.image.Image;

public class Turtle extends Obstacle{
	// h is the height of the turtle
	//w is the width of the turtle
private static int h = 130;
private static int w = 130;

static Image turtle1 = new Image("file:src/p4_group_8_repo/assets/turtle/TurtleAnimation1.png", w, h, true, true);
static Image turtle2 = new Image("file:src/p4_group_8_repo/assets/turtle/TurtleAnimation2.png", w, h, true, true);
static Image turtle3 = new Image("file:src/p4_group_8_repo/assets/turtle/TurtleAnimation3.png", w, h, true, true);

@Override
public void act(long now) {

	if (now/900000000  % 3 ==0) {
		setImage(turtle2);
		
	}
	else if (now/900000000 % 3 == 1) {
		setImage(turtle1);
		
	}
	else if (now/900000000 %3 == 2) {
		setImage(turtle3);
		
	}

	move(getSpeed() , 0);
	if (getX() > 600 && getSpeed()>0)
		setX(-200);
	if (getX() < -75 && getSpeed()<0)
		setX(600);
}

public Turtle(int xpos, int ypos, double speed) {
	setX(xpos);
	setY(ypos);
	super.setSpeed(speed);
	setImage(turtle2);
}

@Override
public String toString() {
	return "success" + super.getSpeed();
	
}




}
