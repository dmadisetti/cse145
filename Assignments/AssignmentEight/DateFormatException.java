public class DateFormatException extends Exception{
	private static final String DEFAULT = "That is an inncorect Date";
	DateFormatException(){
		super(DEFAULT);
	}
	DateFormatException(String message){
		super(message);
	}
}