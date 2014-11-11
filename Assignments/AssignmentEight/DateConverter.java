import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
// This is a class
public class DateConverter{

    // Declaring my variables
    private int[] timeArray;
    private int day,month;

    // Things that shouldn't change
    private final int MAXMONTH = 12;
    private final int MAXDAY = 29;
    private final String FORMATREGEX = "^([0-9]{1,2})/([0-9]{1,2})$";
    private final Pattern PATTERN = Pattern.compile(FORMATREGEX);
    private final String[] MONTHS = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};

    // Exceptions
    private final String BADTIMEFORMAT = "Wrong format";
    private final String BADMONTH = "The month is incorrect";
    private final String BADDAY = "The day is incorrect";
    private final String BADNUMBER = "That doesn't look like a number";

    public DateConverter(){}

    public void setDate(String timeString) throws DateFormatException, DayException, MonthException{
        timeArray = parseDate(timeString);
        
        // Check for validity
        if(timeArray[0] > MAXMONTH)
            throw new MonthException();
        if(timeArray[1] > numDays(timeArray[0]))
            throw new DayException();

        month = timeArray[0];
        day = timeArray[1];
    }

    public String stringDate(){
        return MONTHS[month - 1] + " " + day;
    }

    // Matches string against format and test whether it is valid.
    // Returns array time in the format [hour,minute]
    private int[] parseDate(String timeString) throws DateFormatException{

        //  Let's match and parse against the regex
        Matcher match = PATTERN.matcher(timeString);
        if (!match.matches()){
            // Woops. Guess it's not valid format.
            die(BADTIMEFORMAT);
        }

        // Let's package it all nicely
        int[] timeInts = new int[]{cleanInt(match.group(1)),cleanInt(match.group(2))};

        return timeInts;
    }

    // Turns string to int without ugly exceptions
    private int cleanInt(String integer) throws DateFormatException{
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

    private int numDays(int month){
        return month == 2 ? MAXDAY : MAXDAY + ((month % 7) % 2) + 1;
    }
    
    // Except
    private void die(String exception) throws DateFormatException{
            throw new DateFormatException("EXCEPTION!: " + exception);
    }
}