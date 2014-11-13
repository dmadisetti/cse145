import java.util.Scanner;

public class RPSHumanPlayer extends RPSPlayer{

    //  Init my scanner
    private Scanner scanner = new Scanner(System.in);

    // Constructors are constructorful
    public RPSHumanPlayer(){}
    public void chooseGesture(){
        scanner.nextLine();
    }
}
