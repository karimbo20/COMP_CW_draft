package p4_group_8_repo.structure.obstacles;

import javafx.scene.image.Image;

public class Log extends Obstacle {

	private double speed;
	static Image logLeft = new Image("file:src/p4_group_8_repo/assets/logs/log3.png", 150, 150, true, true);
	static Image logRight = new Image("file:src/p4_group_8_repo/assets/logs/logs.png", 300, 300, true, true);
	
	public Log(int xpos, int ypos, double speed, boolean isLeft) {
		setX(xpos);
		setY(ypos);
		super.setSpeed(speed);
		if(!isLeft) {
			setImage(logLeft);
		}else {
			setImage(logRight);
		}
				
	}

	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
