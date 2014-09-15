import java.util.Scanner;

// Lab 2 say what
public class LabTwo{

    // Helper Class
    private static class Coin {

        // Attributes of le coin
        // I could make getters/setters I guess, but I'm not that bored.
        protected int value;
        protected String name;
        protected String plural;

        public Coin(int value, String name, String plural){
            this.value  = value;
            this.name   = name;
            this.plural = plural;
        }

    }

    // Declaring my variables
    private Scanner scanner = new Scanner(System.in);  // packaged class to read stdin
    private int coinage; // reported coinage
    private int runningCoinage; // working coinage variable to calculate values
    private static final Coin[] CHANGE = new Coin[]{ // final for coin data
         new Coin(25,"quarter","quarters")
        ,new Coin(10,"dime","dimes")
        ,new Coin(5,"nickle", "nickles")
        ,new Coin(1,"penny", "pennies")
    };
    

    // Constructor to start Change Checker
    // More or less just here to hold everything together
    private LabTwo(){
        // Set up craziness
    }

    // Function to prompt for change amount.
    private boolean changePrompt(){

        // Username only needs to be put in once
        System.out.println("Enter a whole number from 1 to 99.");
        System.out.println("The machine will determine a combination of coins");
        coinage = scanner.nextInt();

        // Let's put in some checks
        if (coinage < 1 || coinage > 99){
            System.out.println("Learn how to count. Your number is not between 1 and 99");
            return false;
        }

        // Set temp var
        runningCoinage = coinage;
        return true;
    }

    // Function to output coin values.
    private void run(){

        System.out.println(coinage + " cents in coins:");
        for (Coin coin : CHANGE) {
            // Grab the number of times coin goes into runningCoinage and cast to floor
            int amount = (int)(runningCoinage / coin.value);
            System.out.println("\t" + amount + " " + (amount == 1 ? coin.name : coin.plural)); // Print out results

            // Adjust Running coinage to reflect
            runningCoinage -= coin.value * amount; // or runningCoinage %= coin.value;
        }

    }

    public static void main(String args[]){

        // Create instance
        LabTwo changeChecker = new LabTwo();
        if(changeChecker.changePrompt()) 
            changeChecker.run();

    }
}
