public class SaberException extends Exception{
	private static final String DEFAULT = "BadSaber";
	SaberException(){
		super(DEFAULT);
	}
	SaberException(String message){
		super(message);
	}
}