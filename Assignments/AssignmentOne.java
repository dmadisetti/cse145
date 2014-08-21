import java.io.InputStream;
import java.util.Scanner;

public class AssignmentOne{

	private Scanner scanner = new Scanner(System.in);  // packaged class to read stdin
	private String username; // variable to storee user inputted username
	private String password; // variable to storee user inputted password
	private final String SECRET = "password"; // Super secret. Be better if encrypted.

	// Constructor to start Password Checker
	public AssignmentOne(){
		System.out.println("Password Checker");

		// Username only needs to be put in once
		System.out.println("Please enter your username:");
		username = scanner.nextLine();

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
		System.out.println("Please enter your password:");
		password = scanner.nextLine();

		if(password.equals(SECRET)){
			System.out.println("You are approved by access control!");
			return true;
		}
		return false;
	}

	public static void main(String args[]){
		// Create instance
		new AssignmentOne();
	}

}
