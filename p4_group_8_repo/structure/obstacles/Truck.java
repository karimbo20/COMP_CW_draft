package p4_group_8_repo.structure.obstacles;

import javafx.scene.image.Image;

public class Truck extends Obstacle {
	
	static int truckS = 120;
	static int truckL = 200;
	
	static Image truckShort = new Image("file:src/p4_group_8_repo/assets/truck/truck1Right.png", truckS, truckS, true, true);
	static Image truckLong = new Image("file:src/p4_group_8_repo/assets/truck/truck2Right.png", truckL, truckL, true, true);

	public Truck(int xpos, int ypos, double speed, boolean isLong) {
		setX(xpos);
		setY(ypos);
		super.setSpeed(speed);
		if(isLong) {
			setImage(truckLong);
		}else {
			setImage(truckShort);
		}
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
