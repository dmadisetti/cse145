/**
* AssignmentOneBonus: Does the same password checking 
* rigamoraloe as AssignmentOne, just with jPanel. 
* Fairly messy, just moded the old one
* .__            __
* |  |__ ___  __|  | __  ______
* |  |  \\  \/  /  |/ / /  ___/
* |   Y  \>    <|    <  \___ \ 
* |___|  /__/\_ \__|_ \/____  >
*     \/      \/    \/     \/ 
* Hacked together by Dylan Madisetti
*
* @author  Dylan Madisetti
* @version 2.0, Sept 4, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class AssignmentOneBonus{

    private Scanner scanner = new Scanner(System.in);  // packaged class to read stdin
    private String username; // variable to storee user inputted username
    private String password; // variable to storee user inputted password
    private final String SECRET = "password"; // Super secret. Be better if encrypted as decompiling is totally a thing
    private static JFrame frame = new JFrame("AssignmentOneBonus"); // Create Frame
    static {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Constructor to start Password Checker
    public AssignmentOneBonus(){


        // Grab Username
        username = (String)JOptionPane.showInputDialog(
            frame
            ,"Password Checker\n"
            +"Please enter your username:"
            ,"Password Checker"
            ,JOptionPane.PLAIN_MESSAGE
        );

        if(!validate("Please enter your password:")){
            // User got it wrong
            if(!validate("Try Again")){
                // User got it wrong again
                JOptionPane.showMessageDialog(
                    frame
                    ,"Sorry"
                    ,"Password Checker"
                    ,JOptionPane.ERROR_MESSAGE
                );
            }
        }
        System.exit(0); // Hangs otherwise. Not elegant.
    }

    // Function to check password
    private boolean validate(String message){
        // grab the password from the user
        password = (String)JOptionPane.showInputDialog(
            frame
            ,message
            ,"Password Checker"
            ,JOptionPane.PLAIN_MESSAGE
        );

        // But does it equal?
        if(password.equals(SECRET)){
            JOptionPane.showMessageDialog(
                frame
                ,"You are approved by access control!"
                ,"Password Checker"
                ,JOptionPane.PLAIN_MESSAGE
            );
            return true;
        }

        // Guess you're wrong
        return false;
    }

    public static void main(String args[]){
        // Create instance
        new AssignmentOneBonus();
    }
}
