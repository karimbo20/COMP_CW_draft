package player_act;
import javafx.scene.image.Image;
import frogger_main.Player;
public class DeathAct implements Act {

	/**
	 * This method calls restrict movement method that keeps the player within the screen, and it also checks for any death triggers and loads the correct images for the death animations
	 */
	@Override
	public void act(Actor actor, long now) {
		Player player=(Player)actor;
		restrictmovement(player);
		if(player.carDeath) {
			player.image1=new Image("file:src/resources/cardeath1.png", actor.imgSize, actor.imgSize, true, true);
			player.image2=new Image("file:src/resources/cardeath2.png", actor.imgSize, actor.imgSize, true, true);
			player.image3=new Image("file:src/resources/cardeath3.png", actor.imgSize, actor.imgSize, true, true);
			player.image4=null;
			player.handledeath(now);
		} 

		if(player.waterDeath) {
			player.image1=new Image("file:src/resources/waterdeath1.png", actor.imgSize,actor.imgSize , true, true);
			player.image2=new Image("file:src/resources/waterdeath2.png", actor.imgSize,actor.imgSize , true, true);
			player.image3=new Image("file:src/resources/waterdeath3.png", actor.imgSize,actor.imgSize , true, true);
			player.image4=new Image("file:src/resources/waterdeath4.png", actor.imgSize,actor.imgSize , true, true);
			player.handledeath(now);
		}




	}

	/**
	 * Make sure that the player doesnt go boundries
	 */
	@Override
	public void restrictmovement(Actor actor) {
		if (actor.getY()<0 || actor.getY()>734) {  //stops player from going offscreen down or up
			actor.setX(300);
			actor.setY(679.8+actor.movement);

			if (actor.getX()<0) {//stops player from going offscreen to the left
				actor.move(actor.movement*2, 0);
			}

		}

		if (actor.getX()>500-actor.imgSize/2) {//stops player from going offscreen to the right
			actor.move(-actor.movement*2, 0);
		}




	}

}
