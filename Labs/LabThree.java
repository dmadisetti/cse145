import java.util.Scanner;

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

	// Exceptions
	private final String BADTIMEFORMAT = "You should learn how to read directions. Bad input. ";
	private final String BADHOUR = "If only there were that many hours in a day.";
	private final String BADMINUTE = "There aren't that many minutes in an hour.";
	private final String BADNUMBER = "That doesn't look like a number";

	public LabThree(){
		System.out.println("Enter a time in the format hour:minute");
		timeNow = scanner.next();
		timeArray = parseTime(timeNow);

		System.out.println("Enter a number of minutes to add to this time");
		added = cleanInt(scanner.next());

		totalMinutes = added + timeArray[1];
		minute  = totalMinutes % MODMINUTE;
		hour 	= (timeArray[0] + (int)(totalMinutes / MODMINUTE)) % MODHOUR;

		timeThen = hour + ":" + (minute < 10 ? "0" : "") + minute;

		System.out.println(
			"The time " + added + " minute" 
			+ (added == 1 ? "" : "s") + " after "
			+ timeNow + " is " + timeThen
		);
	}

	private int[] parseTime(String timeString){
		if (!timeString.matches(FORMATREGEX)){
			die(BADTIMEFORMAT);
		}

		String[] time 		= timeString.split(":");
		int[]    timeInts	= new int[]{cleanInt(time[0]),cleanInt(time[1])};

		// Check for validity
		if(timeInts[0] >= MODHOUR)
			die(BADHOUR);
		if(timeInts[1] >= MODMINUTE)
			die(BADMINUTE);

		return timeInts;
	}

	private int cleanInt(String integer){
		int num = 0;
		try{
			num = Integer.parseInt(integer);
		}catch (Exception e) {
			die(BADNUMBER);
		}
		return num;
	}
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