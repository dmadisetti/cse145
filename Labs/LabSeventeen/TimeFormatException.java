public class TimeFormatException extends Exception{
	private static final String DEFAULT = "That is an inncorect time";
	TimeFormatException(){
		super(DEFAULT);
	}
	TimeFormatException(String message){
		super(message);
	}
}