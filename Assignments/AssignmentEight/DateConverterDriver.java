/**
* AssignmentEight: Lab 3 and 17 just slightly different
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
* @version 1.0, Nov 12, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/
import java.util.Scanner;
public class DateConverterDriver {
	
	// this is a class
	public static void main(String[] args) {
		System.out.println("Welcome to the date converter!");		
		
		DateConverter date = new DateConverter();
		Scanner keyboard = new Scanner(System.in);
		
		boolean quit = false;
		while(!quit){
			//Prompt the user
			System.out.println("Enter a numeric date formatted as month/day or \"Exit\" to quit.");
			
			//Gets the user input
			String input = keyboard.nextLine();
			if(input.equalsIgnoreCase("exit")){
				System.out.println("Goodbye!");
				break;
			}

			// Try Date thing
			try{
				date.setDate(input);
				System.out.println("The date is " + date.stringDate());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}