package p4_group_8_repo.structure.obstacles;

public class Position {
public Obstacle getObstacle(String obsType, int xpos, int ypos, double speed, boolean type) {
		
		if(obsType.equalsIgnoreCase("log")) {
			return new Log(xpos, ypos, speed, type);
		}else if(obsType.equalsIgnoreCase("truck")){
			return new Truck(xpos, ypos, speed, type);
		}else if(obsType.equalsIgnoreCase("car")) {
			return new Car(xpos, ypos, speed);
		}else if(obsType.equalsIgnoreCase("turtlefloat")) {
			return new Turtle(xpos, ypos, speed);
		}else if(obsType.equalsIgnoreCase("wetturtle")) {
			return new WetTurtle(xpos, ypos, speed);
		}else {
			return null;
		}
		
	}

}


