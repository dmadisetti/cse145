/**
* @author  Dylan Madisetti
* @version 1.0, Oct 14, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

public class Team{

    private String name = "No Name";
    private int score = 0;
    private final int MAX_POINTS = 3;

    // Constructors are constructorful
    public Team(String aName){
    	name = aName;
    }

    // Returns true on success
    public boolean score(int points){
    	if(points > 0 && points <= MAX_POINTS){
    		score += points;
    		return true;
    	}
    	return false;
    }

    public int getPoints(){
    	return score;
    }

    public String toString(){
    	return "Team " + name;
    }

    public boolean equals(Team b){
    	return b.getPoints() == getPoints();
    }
}