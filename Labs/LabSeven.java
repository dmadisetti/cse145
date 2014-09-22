/**
* @author  Dylan Madisetti
* @version 1.0, Sept 18, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;

public class LabSeven{

    //  Init my scanner
    private Scanner scanner = new Scanner(System.in);
    private int max; // Holds user input for reference
    private String stars; // Temp holds row

    // Constructors are constructorful
    public LabSeven(){
        System.out.println("Welcome to Triangle Maker 9000!  Enter the size of the triangle."); // Print obligatory nonsense
        System.out.println(triangulate(scanner.nextInt())); // grab user input, generate triangle and print it
    }

    // returns string triangle
    private String triangulate(int i){
        max = i; // set max
        return recurse(1,1); // start recursion
    }

    // recursion function to create lines
    private String recurse(int i,int incrementer){
        if (i == 0) return "\n\nDONE!"; // if 0 then the end
        if (i == max) incrementer = -1; // reached max point
        return bunch(i) + recurse(i + incrementer, incrementer); // Call next line
    }

    private String bunch(int x){
        stars = "\n"; // clear variable
        for (int y = 0; y < x; y++) stars += "*"; // add to variable to build row
        return stars; // return row
    }

    // Entry point
    public static void main(String[] args) {
        // Start it off
        new LabSeven();
    }
}
