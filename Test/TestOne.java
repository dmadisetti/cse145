/**
* TestOne: It's a test! This simulates a virtual bouncing ball
*
* @author  Dylan Madisetti
* @version 1.0, Oct 2, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;

public class TestOne{

    private int time    = 0; // Lift off!
    private int bounces = 0; // No bounces ntil we bounce
    private double velocity; // initialized by user
    private double height  = 0; // We start at 0
    private final int g = -32; // They say gravity is a g

    //  Init my scanner
    private Scanner scanner = new Scanner(System.in);

    // Constructors are constructorful
    public TestOne(){
        System.out.println("Welcome to the bouncing ball program\n"); // Print obligatory thing
        System.out.println("Please enter a initial velocity"); // Start it off
        velocity = scanner.nextDouble(); // Grab double since potential for decimal velocities
        while (bounces < 5){ // Only bounce 5 times
            System.out.println("Time:" + time + " Height:" +height); // Print out where we are
            time += 1; // Time goes on
            height += velocity; // Height changes as a function of time and velocity
            velocity += g; // velocity changes as a function of time and acceleration
            if(height <=0){ // Are we going throught the nether worlds?
                height*=-0.5; // Change the height to reflect the bounce
                velocity*=-0.5; // Change the velocity due to a loss of energy
                System.out.println("BOUNCE!"); // BOUNCE BOUNCE BOUNCE!
                bounces++; // Up the bounces, since we bounced
            }
        }
    }

    // Entry point
    public static void main(String[] args) {
        // Start it off
        new TestOne();
    }
}