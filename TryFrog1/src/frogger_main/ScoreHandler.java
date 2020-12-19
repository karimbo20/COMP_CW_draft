package frogger_main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class handles writing and reading the player score to and from a list
 */
public class ScoreHandler {

	public ArrayList<Score> scores;
	public ArrayList<String> names;
	
	int score=0;
	
	Player player;
	
	public File file;
	
	/**
	 * The constructor checks for the text file , and creates one if it doesn't exist, it also calls the readscores function to initialize the scoreboard
	 */
	public ScoreHandler() {
		
		scores = new ArrayList<Score>();
		ArrayList<String> names = new ArrayList<String>();
		
		File file=new File("scoretext.txt");
		try {
			if (file.createNewFile()) {
		        System.out.println("File created: " + file.getName());
		      } else {
		        System.out.println("File already exists.");
		      }	
		}
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		readscores();
		
 
		
		
		
	}
	
	/**
	 * This function writes new data into the file, it works by first adding the new score to the scores list. and then writing all entities of the list to the file in the correct format
	 * @param name the name the player wants to use
	 * @param score the score the player has accumulated
	 * @param level the level the player has reached
	 */
	public void writescores(String name,int score,int level) {
		boolean found=false;
		
		for (int x=0;x<scores.size();x++) {	
			if(scores.get(x).Name.equals( name)) {
				if(scores.get(x).Score < score) {
				scores.get(x).Score=score;
				scores.get(x).Level=level;
				}
				found=true;
			}
		}
		if (!found) {
			scores.add(new Score(name,score,level));
		}
	    
	    try {
		    FileWriter myWriter = new FileWriter("scoretext.txt");
			for (int i=0;i<scores.size();i++) {		

				if (!scores.get(i).Name.equals("")) {
			    myWriter.write(scores.get(i).Name+"\n"+scores.get(i).Score+"\n"+scores.get(i).Level+"\n");
				}
			}
			myWriter.close();
	    }
		catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
	    }
		 
	}
	
	/**
	 * This function reads the score data from the text file and stores it in an array 
	 */
	public void readscores() {
		int second=1;
		String user="";
		int score=0;
		 try {
		      File myObj = new File("scoretext.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  String data = myReader.nextLine();
		    	  if(second==3) {
		    		  
				      scores.add(new Score(user,score,Integer.valueOf(data)));
				      second=1;
		    	  }
		    	  else if (second==1) {
		    		  
		    		  second=2;
		    		  user=data;
		    	  }
		    	  else if (second==2) {
		    		  second=3;
		    		  score=Integer.valueOf(data);
		    	  }
		        
		       
		      }
		      myReader.close();
		    } 
		 catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/**
	 * A public method to get the scores
	 * @return an array containing the player scores
	 */
	public ArrayList<Score> getscore() {
		return(scores);
	}
	
	/**
	 * A function that gets the highscore
	 * @return the highest score
	 */
	public int gethighscore() {
		int hs=0;
		for(int i=0;i<scores.size();i++) {
			if (scores.get(i).Score>hs) {
				hs=scores.get(i).Score;
			}
		} 
		return(hs);
	}
	
	/**
	 * Method to return player points
	 * @return player points
	 */
	public int getPoints() {//sends points to classes that is requested
		return (Player.points);
	}
		
	
	
}
