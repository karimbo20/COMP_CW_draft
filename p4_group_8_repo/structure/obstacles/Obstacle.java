package p4_group_8_repo.structure.obstacles;

import p4_group_8_repo.Act;
import p4_group_8_repo.Actor;

public abstract class Obstacle extends Actor implements Act{
	private double speed;
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	

	public abstract void act(long now);
	
		
}