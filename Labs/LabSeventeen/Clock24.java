import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
// This is a class
public class Clock24{

    // Declaring my variables
    private int[] timeArray;
    private int minute,hour;

    // Things that shouldn't change
    private final int MAXHOUR = 24;
    private final int MAXMINUTE = 60;
    private final int MODHOUR = 12;
    private final String FORMATREGEX = "^([0-9]{1,2}):([0-9]{2})$";
    private final Pattern PATTERN = Pattern.compile(FORMATREGEX);

    // Exceptions
    private final String BADTIMEFORMAT = "Wrong format";
    private final String BADHOUR = "The hour is incorrect";
    private final String BADMINUTE = "The minute is incorrect";
    private final String BADNUMBER = "That doesn't look like a number";

    public Clock24(){}

    public void setTime(String timeString) throws TimeFormatException{
        timeArray = parseTime(timeString);
        hour = timeArray[0];
        minute = timeArray[1];
    }

    public void printTime(){
        System.out.println((hour == 12 || hour == 0? 12 : hour % MODHOUR) + ":" + (minute < 10? "0" : "") + minute + " " + (hour/MODHOUR == 0 ? "AM" : "PM"));
    }

    // Matches string against format and test whether it is valid.
    // Returns array time in the format [hour,minute]
    private int[] parseTime(String timeString) throws TimeFormatException{

        //  Let's match and parse against the regex
        Matcher match = PATTERN.matcher(timeString);
        if (!match.matches()){
            // Woops. Guess it's not valid format.
            die(BADTIMEFORMAT);
        }

        // Let's package it all nicely
        int[] timeInts = new int[]{cleanInt(match.group(1)),cleanInt(match.group(2))};

        // Check for validity
        if(timeInts[0] >= MAXHOUR)
            die(BADHOUR);
        if(timeInts[1] >= MAXMINUTE)
            die(BADMINUTE);

        return timeInts;
    }

    // Turns string to int without ugly exceptions
    private int cleanInt(String integer) throws TimeFormatException{
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
    
    // Except
    private void die(String exception) throws TimeFormatException{
            throw new TimeFormatException("EXCEPTION!: " + exception);
    }
}