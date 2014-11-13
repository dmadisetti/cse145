public abstract class RPSPlayer implements RPSPlayerInterface{

    private String gesture;
    private int points = 0;
    static final String[] GESTURES = new String[] {"rock","paper","scissors"};

    // Constructors are constructorful
    public RPSPlayer(){}

    public String getGesture() {
        return gesture;
    }
    public int getPoints(){
        return points;
    }
    public void setGesture(String aGesture){
        String lowered = aGesture.toLowerCase();
        boolean valid = false; 
        for (String g : GESTURES) {
            if(lowered.equals(g)){
                valid = true;
                break;
            }
        }
        if(!valid) new Exception("Learn to follow instructions");

        gesture = lowered;
    }
    public void setPoints(int aPoints){
        points = aPoints;
    }

}