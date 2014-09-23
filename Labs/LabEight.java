/**
* @author  Dylan Madisetti
* @version 1.0, Sept 22, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;

public class LabEight{

    //  Init my scanner
    private Scanner scanner = new Scanner(System.in);
    private double average; // Hold average
    private int runningTotal; // Total temp
    private int[] temps = new int[10]; // Holds temperatures

    // Constructors are constructorful
    public LabEight(){
        System.out.print("Welcome to the above average temperature tester program.\n\n"); // Print obligatory nonsense
        for (int i = 0; i < temps.length ; i++ ) {
	        System.out.println("Please enter the temperature for day " + (i + 1)); // Prompt for temp
 			temps[i] = scanner.nextInt(); // next
 			runningTotal += temps[i]; // Add to total
        }
        average = runningTotal/temps.length; // Grab average
        System.out.println("The average temperature was " + average); // Print average
		System.out.println("The days that were above average were");
        for (int i = 0; i < temps.length ; i++ ) {
        	if(temps[i] > average) System.out.printf("Day %d with %d\n",i + 1,temps[i]); // Compare and print if need be
        }
    }

    // Entry point
    public static void main(String[] args) {
        // Start it off
        new LabEight();
    }
}
