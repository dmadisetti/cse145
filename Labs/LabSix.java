/**
* @author  Dylan Madisetti
* @version 1.0, Sept 16, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.HashMap;
import java.util.Scanner;

public class LabSix{

    //  Init my scanner
    private Scanner scanner = new Scanner(System.in);
    private String key;
    private int score;
    private int i = 0;
    private int total = 0;
    private int max = 0;
    private int min = 100;
    private static final HashMap<String, Integer> GRADES = new HashMap<String, Integer>();
    static {
        GRADES.put("A",0);
        GRADES.put("B",0);
        GRADES.put("C",0);
        GRADES.put("D",0);
        GRADES.put("F",0);
    }

    // Constructors are constructorful
    public LabSix(){
        System.out.println("Welcome to Grader-ator!"); // Print obligatory nonsense
        while(true){
            System.out.println("Enter a grade from 0 to 100, or enter a negative number to quit"); // Prompt user for score
            score = scanner.nextInt();
            if(score < 0) break; // if neg then over
            if(score > 100){
                System.out.println("Score to large");
                continue;
            }
            key = grader(score); // Look up based on score
            GRADES.put(key,GRADES.get(key) + 1); // Let's store this
            max = score > max ? score : max; // score maxer than max?
            min = score < min ? score : min; // score miner than min?
            i++; // Running count
            total += score; // Running score
        }
        for (String letter : GRADES.keySet()) {
            System.out.println("Number of " + letter + "'s = "+ GRADES.get(letter)); // print out number of ness
        }
        System.out.println("Highest Score = " + max); // Print out max
        System.out.println("Lowest Score = " + min); // Print out min
        System.out.println("Average Score = " + ((double)total/(double)i)); // Print out Average
    }

    private String grader(int grade){
        switch((int)(grade/10)){
            case 10:
            case 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            case 6:
                return "D";
        }
        return "F";
    }

    // Entry point
    public static void main(String[] args) {
        // Start it off
        new LabSix();
    }
}
