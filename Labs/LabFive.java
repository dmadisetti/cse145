/**
* @author  Dylan Madisetti
* @version 1.0, Sept 11, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.HashMap;
import java.util.Scanner;

public class LabFive{

	//  Init my scanner
	private Scanner scanner = new Scanner(System.in);

	// Just allocating some variables
	private int height;
	private int weight;
	private int age;
	private double bmr;
	private double lifestyle;
	private GenderService gender;

	// Let's make this guys final and set it up. Not going to change
	private static final HashMap<String, Double> LIFE = new HashMap<String, Double>();
	static {
		LIFE.put("sedentary",1.2);
		LIFE.put("somewhat active",1.3);
		LIFE.put("active",1.4);
		LIFE.put("highly active",1.5);
	}

	// Just a helper class to contain variables based on gender
	private class GenderService{
		public double mWeight;
		public double mHeight;
		public double mAge;
		public double base;
		public GenderService(String gender){
			// Are you woman or are you dancer?
			if(gender.toLowerCase() == "f"){
				mWeight = 4.3;
				mHeight = 4.7;
				mAge = 4.7;
				base = 655;
			}else{
				mWeight = 6.3;
				mHeight = 12.9;
				mAge = 6.8;
				base = 66;
			}
		}
	} 

	// Constructors are constructorful
	public LabFive(){
		System.out.println("Welcome to the leap year program! Enter a year in yyyy format"); // Start it off
		System.out.println("First are you male or female? Enter M or F?"); // Prompt for gender
	    gender = new GenderService(scanner.next());
		System.out.println("How tall are you in inches?"); // Prompt for height
	    height = scanner.nextInt();
		System.out.println("What is your weight in pounds?"); // Prompt for weight
	    weight = scanner.nextInt(); 
		System.out.println("What is your age in years?"); // Prompt for age
	    age = scanner.nextInt();
		System.out.println("How would you describe your lifestyle? Sedentary, Somewhat Active, Active, Highly Active?"); // prompt for lifestyle
	    lifestyle = LIFE.get(scanner.next().toLowerCase());
	    bmr = (gender.base + gender.mWeight * weight + gender.mHeight * height - gender.mAge * age) * lifestyle; // Calculate
		System.out.println("Your BMR is " + bmr + " calories!"); // Print it out
	}

	// Entry point
	public static void main(String[] args) {
		// Start it off
		new LabFive();
	}
}
