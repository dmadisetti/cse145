/**
* AssignmentFive: Determines if string is palindrome
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
* @version 1.0, Oct 2, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/
import java.util.Scanner;

public class AssignmentFive{

    private Scanner scanner = new Scanner(System.in);  // packaged class to read stdin
    private String palindrome;

    // Constructor to start Assignment Two
    private AssignmentFive(){
        // Output ma name
        System.out.println("Enter a word or phrase and I’ll tell you if it’s a palindrome.");
        palindrome = scanner.nextLine();
        System.out.println(palindrome + " is "+ (isPalindrome(palindrome)?"":"not ") + "a palindrome."); // print if palindrome
        System.out.println("Done!");
    }

	public boolean isPalindrome(String tacocat){
		char[] charArray = tacocat.replaceAll(" ", "").toLowerCase().toCharArray();
		int len = charArray.length - 1;
		int halflen = Math.round(charArray.length/2);
 
		for(int i = 0;i < halflen;i++){
			if(charArray[i] == charArray[len-i])
				continue;
			return false;
		}
		return true;
	}

    public static void main(String args[]){
        // Create instance
        new AssignmentFive();
    }
}