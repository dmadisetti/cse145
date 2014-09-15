/**
* AssignmentOne: Asks users for username. Does nothing
* with username. Asks user for password and checks it 
* against plaintext password.
* .__            __            
* |  |__ ___  __|  | __  ______
* |  |  \\  \/  /  |/ / /  ___/
* |   Y  \>    <|    <  \___ \ 
* |___|  /__/\_ \__|_ \/____  >
*     \/      \/    \/     \/ 
* Hacked together by Dylan Madisetti
*
* @author  Dylan Madisetti
* @version 1.0, Aug 21, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/
import java.io.InputStream;
import java.util.Scanner;


public class AssignmentOne{

    private Scanner scanner = new Scanner(System.in);  // packaged class to read stdin
    private String username; // variable to storee user inputted username
    private String password; // variable to storee user inputted password
    private final String SECRET = "password"; // Super secret. Be better if encrypted as decompiling is totally a thing

    // Constructor to start Password Checker
    public AssignmentOne(){
        // Output ma name
        System.out.println("Password Checker");

        // Username only needs to be put in once
        System.out.println("Please enter your username:");
        username = scanner.nextLine(); // Frankly useless

        if(!validate()){
            // User got it wrong
            System.out.println("Try Again");
            if(!validate()){
                // User got it wrong again
                System.out.println("Sorry");
            }
        }
    }

    // Function to check password
    private boolean validate(){
        // grab the password from the user
        System.out.println("Please enter your password:");
        password = scanner.nextLine();

        // But does it equal?
        if(password.equals(SECRET)){
            System.out.println("You are approved by access control!");
            return true;
        }

        // Guess you're wrong
        return false;
    }

    public static void main(String args[]){
        // Create instance
        new AssignmentOne();
    }
}
