import java.util.Random;

public class RPSComputerPlayer extends RPSPlayer{

    private Random random = new Random(); // Zoidberg

    // Constructors are constructorful
    public RPSComputerPlayer(){}
    public void chooseGesture(){
        setGesture(GESTURES[random.nextInt(GESTURES.length)]);
    }
}
