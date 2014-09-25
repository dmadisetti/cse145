/**
* AssignmentFour: It's a game! move around and try not to die
*
* .__            __            
* |  |__ ___  __|  | __  ______
* |  |  \\  \/  /  |/ / /  ___/
* |   Y  \>    <|    <  \___ \ 
* |___|  /__/\_ \__|_ \/____  >
*     \/      \/    \/     \/ 
* Hacked together by Dylan Madisetti
*
* @author  Dylan Madisetti
* @version 1.0, Sept 25, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/
import java.util.Scanner;
import java.util.Random;

public class AssignmentFour{

    private Scanner scanner = new Scanner(System.in);  // packaged class to read stdin
    private boolean playing = true;
    private final int SIZEX = 10; // Board size
    private final int SIZEY = 10; // Board size
    private Game game = new Game(SIZEX,SIZEY); // Woo! New Game

    // Constructor to start 
    private AssignmentFour(){
        System.out.println("Welcome to Mine Walker.  Get the ice cream cone and avoid the mines"); // Print out obligatory nonsense
        do{
            do{
                System.out.println(game.render()); // Print the board
                game.move(prompt("X", true),prompt("Y", false)); // Move from prompts
            }while(!game.gameover); // Did you lose?
            System.out.println((game.win? "Mmmm. Icecream." : "Boom! Dead!")); // Print whether win or lose

            // Play again or restart?
            System.out.println("Do you want to play again? (true/false)");            
            if(!scanner.nextBoolean()) playing = false;
            else game.restart();                
        }while(playing);
    }

    // Prompt user for input
    private int prompt(String direction, boolean fatal){
        System.out.println("Enter either a -1, 0, or 1 in the " + direction + (fatal ? " or 9 to quit":""));
        int next = scanner.nextInt();
        if(fatal && next == 9) System.exit(1); // Oh no! Exit
        if(Math.abs(next) * next == next) return next; // only true for -1,0,1
        System.out.println("Didn't move. Bad input"); // Didn't read the instructions did you?
        return 0;
    }

    // Just a class to hold this all together
    // Ideally like another file
    private static class Game{
        private static enum Spot {Mine,Empty,Player,IceCream} // Different types of spots
        private final double MINE_PERCENT = 0.1;
        private Spot[][] board;
        private int[] playerxy = new int[]{0,0}; // Holds player pos
        private boolean win = false; // Has I won?
        private boolean gameover = false; // Is it over already?
        private Random random = new Random(); // Zoidberg
        private int height;
        private int length;

        public Game(int height,int length){
            this.height = height; // hold on to these guys
            this.length = length;
            board = new Spot[height][length]; // create board
            restart(); // Set it up
        }

        // Burn it all!
        public void restart(){
            int x,y;
            int mines = (int)(length * height * MINE_PERCENT);
            
            // reset variables
            playerxy[0] = playerxy[1] = 0;
            win = gameover = false;

            // Clear the board
            clear();

            // Seed Mines
            do{
                x = random.nextInt(height - 1) + 1; // displaces so not 0,0 or last,last
                y = random.nextInt(length - 1) + 1;
                if(board[x][y] == Spot.Empty){ // Mined your place isn't already set
                    board[x][y] = Spot.Mine;
                    mines--;
                }
            }while(mines > 0); // set mines

            // Set Players
            board[0][0] = Spot.Player;
            board[height - 1][length - 1] = Spot.IceCream;
        }

        // Return string, because a void function would be a crime against humanity 
        // and essentially functionless for anything else but printing
        public String render(){
            String visual = "";
            // For each, string it together
            for (int y = 0; y < board.length ; y++ ) {
                for (int x = 0; x < board[y].length ; x++ ) {
                    switch(board[y][x]){
                        case Player:
                            visual += "X";
                            break;
                        case IceCream:
                            visual += "^"; // OoOoo0o, Icecream
                            break;
                        /* Uncoment for testing
                        case Mine:
                            visual += "o";
                            break;*/
                        default:
                            visual += "_"; // Nothing to see here
                    }
                }
                visual += "\n"; // Next line
            }
            return visual;
        }

        // Move it!
        public void move(int x, int y){
            try{
                board[playerxy[0]][playerxy[1]] = Spot.Empty; // set old spot to empty
                playerxy[0] += y; // update coordinates
                playerxy[1] += x; // update coordinates
                win      = board[playerxy[0]][playerxy[1]] == Spot.IceCream;    // has I won?
                gameover = win || board[playerxy[0]][playerxy[1]] == Spot.Mine; // has I won or lost?
                board[playerxy[0]][playerxy[1]] = Spot.Player; // Update player
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Can't move there"); // There's no escaping the matrix
            }
        }

        // For each iterate and set to empty
        private void clear(){
            for (int y = 0; y < board.length ; y++ ) {
                for (int x = 0; x < board[y].length ; x++ ) {
                    board[y][x] = Spot.Empty;
                }                
            }
        }
    }

    // Entry point
    public static void main(String args[]){
        // Create instance
        new AssignmentFour();
    }
}