public class DayException extends Exception{
	private static final String DEFAULT = "Day Exception: This day is in the wrong range for the month provided.";
	DayException(){
		super(DEFAULT);
	}
	DayException(String message){
		super(message);
	}
}