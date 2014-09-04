import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
// This is a class
public class LabThree{

	// Declaring my variables
	private Scanner scanner = new Scanner(System.in);  // packaged class to read stdin
	private String timeNow,timeThen;
	private int[] timeArray;
	private int added,totalMinutes,minute,hour;

	// Things that shouldn't change
	private final int MODHOUR = 24;
	private final int MODMINUTE = 60;
	private final String FORMATREGEX = "^([0-9]{1,2}):([0-9]{2})$";
	private final Pattern PATTERN = Pattern.compile(FORMATREGEX);

	// Exceptions
	private final String BADTIMEFORMAT = "You should learn how to read directions. Bad input. ";
	private final String BADHOUR = "If only there were that many hours in a day.";
	private final String BADMINUTE = "There aren't that many minutes in an hour.";
	private final String BADNUMBER = "That doesn't look like a number";

	public LabThree(){
		// Prompt user and capture time
		System.out.println("Enter a time in the format hour:minute");
		timeNow = scanner.next();
		timeArray = parseTime(timeNow); // Validate and parse user input

		// Prompt, capture and validate time to be added
		System.out.println("Enter a number of minutes to add to this time");
		added = cleanInt(scanner.next());

		// Let's do some calculations
		totalMinutes = added + timeArray[1]; // How many minutes total?
		minute  = totalMinutes % MODMINUTE; // Mod of these minutes?
		hour 	= (timeArray[0] + (int)(totalMinutes / MODMINUTE)) % MODHOUR; // Hours added

		// Ternary to make things pretty and concatinate our findings
		timeThen = hour + ":" + (minute < 10 ? "0" : "") + minute;

		// Print what we've learned
		System.out.println(
			"The time " + added + " minute" 
			+ (added == 1 ? "" : "s") + " after "
			+ timeNow + " is " + timeThen
		);
	}

	// Matches string against format and test whether it is valid.
	// Returns array time in the format [hour,minute]
	private int[] parseTime(String timeString){

		// 	Let's match and parse against the regex
		Matcher match = PATTERN.matcher(timeString);
		if (!match.matches()){
			// Woops. Guess it's not valid format.
			die(BADTIMEFORMAT);
		}

		// Let's package it all nicely
		int[] timeInts = new int[]{cleanInt(match.group(1)),cleanInt(match.group(2))};

		// Check for validity
		if(timeInts[0] >= MODHOUR)
			die(BADHOUR);
		if(timeInts[1] >= MODMINUTE)
			die(BADMINUTE);

		return timeInts;
	}

	// Turns string to int without ugly exceptions
	private int cleanInt(String integer){
		int num = 0;
		try{
			num = Integer.parseInt(integer);
		}catch (Exception e) {
			die(BADNUMBER);
		}
		// Won't return if it breaks, 
		// but hear to appease the javas
		return num;
	}
	
	// Let's kill it. Fairly bad practice, 
	// but easier than a junk load of conditional
	private void die(String exception){
			System.err.println(exception);
			System.out.println("Exiting..");
			System.exit(0);
	}

	// Code is called from here
	public static void main(String args[]){
		new LabThree();
	}
}