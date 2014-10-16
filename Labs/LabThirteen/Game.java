/**
* @author  Dylan Madisetti
* @version 1.0, Oct 16, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game{

    private Scanner scanner = new Scanner(System.in); //  Init my scanner
    private Team[] teams = new Team[2]; // Has 2 teams
    private boolean over = false; // Can't be over before we've begun

    // Regex for input
	private Matcher match;
    private final String OVER = "over";
    private final String REGEX = "^(over|(a|b) ([0-9]*))$";
    private final Pattern PATTERN = Pattern.compile(REGEX);

    // Constructors are constructorful
    public Game(){
    	System.out.println("Welcome to a game of basket ball");
    	setTeam(0); // The instructions are wrong. Teams go in the constructor. 
    	setTeam(1); // There shouldn't be a game without teams
    }

    // Should not be capitalized
    public void Start(){
    	while(!over){
    		System.out.println("\nEnter the team (either a or b) and a score.  Or enter 'over' to end the game");

	        //  Let's check, match and parse against the regex
    		match = PATTERN.matcher(scanner.nextLine());
	        if (!match.matches()){
	    		System.out.println("Invalid format!"); // Woops. Guess it's not valid format.
	    		continue;
	        }

	        // Is it over yet?
	        if(match.group(1).equals("over")){
	        	over = true;
				System.out.println("The game is over");
			// If no over attempt to set score
	        }else if(!teams[match.group(2).equals("a") ? 0 : 1].score(Integer.parseInt(match.group(3)))){ // I should have probably broken this up, but golf is kinda fun. You should see me with anonymous functions in python
		       	System.out.println("Invalid Score!"); // score returned false
		    }

	        // How are we doing?
	        report();
    	}
    }

    private void report(){
    	// Spit out junk
        regurgitate(teams[0]);
    	regurgitate(teams[1]);

    	// Tied or do we have a winnr?
    	if(teams[0].equals(teams[1])){
    		System.out.println("They are tied!!!");
    	}else{
	    	System.out.println(compare(teams[0],teams[1]).toString() + " is winning.");
		}
    }

    // Just print out stuff
    private void regurgitate(Team x){
	    System.out.println(x.toString() + " has " + x.getPoints() + " Points");
    }

    // Which is bigger?
    private Team compare(Team a, Team b){
    	return a.getPoints() > b.getPoints()? a : b;
    }

    // Set teams
    private void setTeam(int index){
    	System.out.println("Enter the name for team " + (index+1));
    	teams[index] = new Team(scanner.nextLine());
    }
}