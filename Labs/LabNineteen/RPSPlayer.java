public abstract class RPSHumanPlayer implements RPSPlayerInterface{

    private String gesture;

    // Constructors are constructorful
    public RPSHumanPlayer(){}

    public String getGesture() {
        return gesture;
    }
    public void setGesture(String aGesture){
        gesture = aGesture;
    }
}