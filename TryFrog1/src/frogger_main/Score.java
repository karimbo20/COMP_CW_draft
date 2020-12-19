package frogger_main;

public class Score{


    public String Name;
    public int Score;
    public int Level;
  
 
    /**
     * The constructor
     * @param name the Name which the player wants to use
     * @param score the score the player has accumulated
     * @param level the level the player has reached
     */
    public Score(String name, int score,int level) {
    	
        this.Name = name;
        this.Score = score;
        this.Level=level;
    
    }
    public String getName() {
    	return(Name);
    }
    
    public int getScore() {
    	return(Score);
    }
    
    public int getLevel() {
    	return(Level);
    }
    
    public void setName(String Name) {
    	this.Name=Name;
    }
	    
	    public void setScore(int Score) {
    	this.Score=Score;
    }
    
    public void setLevel(int Level) {
    	this.Level=Level;
    }
    
   
    
}
