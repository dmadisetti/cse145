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
    private Team[] teams = new Team[2];
    private boolean over = false;
	private Matcher match;
    private final String OVER = "over";
    private final String REGEX = "^(over|(a|b) ([0-9]*))$";
    private final Pattern PATTERN = Pattern.compile(REGEX);

    // Constructors are constructorful
    public Game(){
    	System.out.println("Welcome to a game of basket ball");
    	set(0);
    	set(1);
    }

    // Should not be capitalized
    public void Start(){
    	while(!over){
    		System.out.println("\nEnter the team (either a or b) and a score.  Or enter 'over' to end the game");

	        //  Let's match and parse against the regex
    		match = PATTERN.matcher(scanner.nextLine());
	        if (!match.matches()){
	    		System.out.println("Invalid format!"); // Woops. Guess it's not valid format.
	    		continue;
	        }

	        // Is it over yet?
	        if(match.group(1).equals("over")){
	        	over = true;
				System.out.println("The game is over");
	        }else if(!teams[match.group(2).equals("a") ? 0 : 1].score(Integer.parseInt(match.group(3)))){
		       	System.out.println("Invalid Score!");
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

    private void regurgitate(Team x){
	    	System.out.println(x.toString() + " has " + x.getPoints() + " Points");
    }

    private Team compare(Team a, Team b){
    	return a.getPoints() > b.getPoints()? a : b;
    }

    private void set(int index){
    	System.out.println("Enter the name for team " + (index+1));
    	teams[index] = new Team(scanner.nextLine());
    }
}