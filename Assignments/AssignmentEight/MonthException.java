public class MonthException extends Exception{
	private static final String DEFAULT = "Month Exception: Months must between 1 and 12 inclusively.";
	MonthException(){
		super(DEFAULT);
	}
	MonthException(String message){
		super(message);
	}
}