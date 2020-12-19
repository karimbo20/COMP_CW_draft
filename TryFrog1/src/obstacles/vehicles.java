package obstacles;
import javafx.scene.image.Image;
import player_act.Actor;
import player_act.ActorMovement;



/**
 * This class defines the vehicles of the game
 *
 */
public class vehicles extends Actor {

	int ypos=0;
	int temp=0;

	/**
	 * This class instantiates the vehicle, sets the photo ,vehicles type and the position according to the type of vehicle it is
	 * @param imageLink the sprite of the vehicle
	 * @param s speed of vehicle
	 * @param w width of vehicle sprite
	 * @param h height of vehicle sprite
	 */
	public vehicles(String imageLink, double s, int w, int h) {
		act=new ActorMovement();

		if (imageLink.contains("car") ) { type="car"+String.valueOf(s);}
		if (imageLink.contains("truck1")) { type=("trucksmall"+String.valueOf(s));}
		if (imageLink.contains("truck2")) { type=("truckbig"+String.valueOf(s));}



		if (temp!=0) {ypos=temp;}
		setY(ypos);
		setImage(new Image(imageLink, w,h, true, true));
		speed = s;
	}


}