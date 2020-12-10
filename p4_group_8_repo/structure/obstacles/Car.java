package p4_group_8_repo.structure.obstacles;

import javafx.scene.image.Image;


public class Car extends Obstacle {
	
	static int carSize = 50;
	static Image car = new Image("file:src/p4_group_8_repo/assets/car/car1Left.png", carSize, carSize, true, true);
	
	
	public Car(int xpos, int ypos, double speed) {
		setX(xpos);
		setY(ypos);
		super.setSpeed(speed);
		setImage(car);
	}
	@Override
	public void act(long now) {
		move(getSpeed() , 0);
		if (getX()>600 && getSpeed()>0)
			setX(-180);
		if (getX()<-300 && getSpeed()<0)
			setX(700);
		
	}
	
	
	
}
