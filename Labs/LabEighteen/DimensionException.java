public class DimensionException extends Exception{
	private static final String DEFAULT = "Dimensions must be of length one at least";
	DimensionException(){
		super(DEFAULT);
	}
	DimensionException(String message){
		super(message);
	}
}