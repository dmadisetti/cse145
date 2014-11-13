import java.util.Random;

public class RPSComputerPlayer extends RPSPlayer{

    private Random random = new Random(); // Zoidberg

    // Constructors are constructorful
    public RPSComputerPlayer(){}
    public void chooseGesture(){
        gesture = GESTURES.getKeys()[random.nextInt(2)];
    }
}
