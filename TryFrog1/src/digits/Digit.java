package digits;



import javafx.scene.image.Image;
import player_act.Actor;
import player_act.ActorMovement;


/**
 * this class is for the digits used for score y
 * @author karim
 *
 */
public class Digit extends Actor{
	int dim; //dimensions of the digit
	Image img1;
	
	//gets p4_group_8_repo for numbers and puts it in place
	public Digit(int n, int dim, int x, int y) {
		
		act=new ActorMovement();
		img1 = new Image("file:src/resources/"+n+".png", dim, dim, true, true);
		setImage(img1);
		setX(x);
		setY(y);
	}

	
	
	
	
}