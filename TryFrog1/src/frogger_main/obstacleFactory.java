package frogger_main;


import player_act.Actor;
import digits.Digit;
import digits.End;

import java.util.ArrayList;
import java.util.Collections;

import obstacles.Log;
import obstacles.Turtle;
import obstacles.WetTurtle;
import obstacles.vehicles;


/**
 * This class is in charge of initializing all obstacles attached to the root node
 * @author karim
 *
 */
public class obstacleFactory{

	/**
	 * The root node
	 */
	MyStage background;
	
	/**
	 * Array to keep track of the digits on the screen
	 */
	public ArrayList<Actor> digits;
	
	/**
	 * Array to keep track of all movable objects
	 */
	ArrayList<Actor> adder=new ArrayList<Actor>();
	
	ArrayList<End> ends=new ArrayList<End>();
	
	double add=0;
	
	
	/**
	 * The constructor does nothing but initiates a list that keeps track of all digits on stage
	 */
	public obstacleFactory() {
		
		digits=new ArrayList<Actor>();

		
		}

	/**
	 * This method returns the bonus speed each obstacle should get according to the level reached
	 * Every level the speed increases by 0.05
	 */
	private void getbonus( ) {
		for(int i=0;i<background.lvl;i++) {
			add=add+0.0625;
			
		}
	}
	
	
	/**
	 * This method instantiates cars and trucks and adds them to to the adder array which stores the game objects
	 */
	private void addobstacles() {
		adder.add(new vehicles("file:src/resources/truck1"+"Right.png",   Double.sum(0.35,add), 120, 120));
		adder.add(new vehicles("file:src/resources/truck1"+"Right.png",  Double.sum(0.35,add), 120, 120));
		adder.add(new vehicles("file:src/resources/truck1"+"Right.png",  Double.sum(0.35,add), 120, 120));
		adder.add(new vehicles("file:src/resources/car1Left.png",  Double.sum(-0.35,-add), 50, 50));
		adder.add(new vehicles("file:src/resources/car1Left.png",  Double.sum(-0.35,-add), 50, 50));
		adder.add(new vehicles("file:src/resources/car1Left.png",  Double.sum(-0.35,-add), 50, 50));
		adder.add(new vehicles("file:src/resources/car1right.png",  Double.sum(0.55,add), 50, 50));
		adder.add(new vehicles("file:src/resources/truck2Right.png",  Double.sum(0.35,add), 200, 200));
		adder.add(new vehicles("file:src/resources/truck2Right.png",   Double.sum(0.35,add), 200, 200));
		adder.add(new vehicles("file:src/resources/car1Left.png",  Double.sum(-0.35,-add), 50, 50));
		
	
		
		
	}
	
	/**
	 * This method instantiates the 4 end holes in the game and adds them to the game background
	 */
	private void addends( ) {
		ends.add(new End());
		ends.add(new End());
		ends.add(new End());
		ends.add(new End());
	  
	}
	
	/**
	 * This method instantiates the logs and adds them to the adder array which contains the objects
	 */
	private void addlogs( ) {
		
		
		adder.add(new Log("file:src/resources/log3.png",  Double.sum(add, 0.25)));
		adder.add(new Log("file:src/resources/log3.png",   Double.sum(add, 0.25)));
		adder.add(new Log("file:src/resources/log3.png",   Double.sum(add, 0.25)));
		adder.add(new Log("file:src/resources/logs.png",   Double.sum(-add, -0.45)));
		adder.add(new Log("file:src/resources/logs.png",   Double.sum(-add, -0.45)));
		adder.add(new Log("file:src/resources/log3.png",   Double.sum(add, 0.25)));
		adder.add(new Log("file:src/resources/log3.png",  Double.sum(add, 0.25)));
		adder.add(new Log("file:src/resources/log3.png",  Double.sum(add, 0.25)));
		
	}
	
	/**
	 * This method instantiates the turtles and wet turtles and adds them to the adder array which stores the game objects
	 */
	private void addturtles( ) {


		    adder.add(new Turtle(Double.sum(add, 0.35)));
		    adder.add(new Turtle(Double.sum(add, 0.35)));
			adder.add(new Turtle(Double.sum(add, 0.35)));
			adder.add(new WetTurtle(Double.sum(add, 0.35)));
			adder.add(new WetTurtle(Double.sum(-add, -0.35)));
			adder.add(new WetTurtle(Double.sum(-add, -0.35)));
			adder.add(new WetTurtle(Double.sum(-add, -0.35)));
			

		
	}
	
	/**
	 * This is the main method of this class and its called to from other classes to initiates all objects in the scene 
	 * after it runs the instantiating functions, it shuffles the adder array which contain all moving objects and add them to the background to make the obstacles spawn
	 * randomly in different dimension when the level is changed
	 * @param background This is the root node of the scene, all objects need to be attached to it as a child
	 */
	public void addobjects(MyStage background) {
		this.background=background;
		//sets background image |
	  		adder.clear();
	  	    
	  		getbonus();
	  		
	  		//adding objects to background game- makes them children nodes
	  		
	  		

			
	  		addturtles();
	  		addturtles();
	  		addlogs();
	  		addends();
	  		addobstacles();
	  		addlayout();
	  		

	  		for(int i=0;i<ends.size();i++) {
	  			background.add(ends.get(i));
	  		}
	  		Collections.shuffle(adder);
	  		
	  		for(int i=0;i<adder.size();i++) {
				background.add(adder.get(i));
			}
	  		
	  		background.add(new Digit(0, 30, 400, 40));
	  		
	  		BackgroundImage froggerback = new BackgroundImage("file:src/resources/ikogsKW.png");
	  		background.add(froggerback);
	}
	

	/**
	 * This method initiates the score and hiscore labels on top of the screen
	 */
	private void addlayout( ) {
		background.add(new layout("file:src/resources/HighScoreimage.png",140, 180, 10));
		background.add(new layout("file:src/resources/Scoreimage.png",100, 360, 10));
	}
	
	/**
	 * This method manages the digits used for the score and highscore on top of the screen
	 * @param n This is the number to be displayed as digits
	 * @param highpos This boolean tells the method if it should place the digits under score or under highscore(if true then under highscore)
	 * it also deleted all current score digits from the screen before updating them
	 */
	public void setNumber(int n,boolean highpos ) { // set n as digits on screen
		
		for(int i=0;i<digits.size();i++) {
			
			background.remove(digits.get(i));
		
		}
		Actor temp;
    	int shift = 0;//shifts positions for bigger digits
    	int x=400;
    	if(highpos) {x=270;}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;//calculations to check number digit by digit
    		  n = d;
    		  temp=new Digit(k, 30, x - shift, 40);
    		  if(!highpos) {digits.add(temp);}
    		  background.addfront(temp);//360 is end of number, works backwards
    		  shift+=30;//move back 30 more pixels
    		}
    }
	
	
}