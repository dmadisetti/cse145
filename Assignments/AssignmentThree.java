/**
* AssignmentThree: Output a limited combination of numbers
* which the sum of the squares equal a predetermined number
* In this case combination of 4 adding to 200
* .__            __            
* |  |__ ___  __|  | __  ______
* |  |  \\  \/  /  |/ / /  ___/
* |   Y  \>    <|    <  \___ \ 
* |___|  /__/\_ \__|_ \/____  >
*     \/      \/    \/     \/ 
* Hacked together by Dylan Madisetti
*
* @author  Dylan Madisetti
* @version 1.0, Sept 18, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

public class AssignmentThree{

    private final int TARGET = 200; // Total hours
    private final int RECURSION_DEPTH = 3; // 4 straws or 3 counting from 0
    private int[] answers = new int[RECURSION_DEPTH + 1]; // allocate int for each level

    // Constructor to start 
    private AssignmentThree(){
        if(recurse(0,0,1)){ // Run calculation from top
            for (int answer : answers) { // spit out each answer
                System.out.println(answer);
            }
        }else{ // Function returned false. Woops.
            System.out.println("This doesn't look possible kid.");
        }
    }

    private boolean recurse(int depth, int sum, int i){
        if(depth > RECURSION_DEPTH       // Only 4 straws, so stop
            || i * i > TARGET - sum) return false; // not possible to have hours that exceed the target
        int x = i * i;      // Total hours worked
        answers[depth] = i; // store straw incase it works
        return sum + x == TARGET                 // Check to see if it works
            || recurse(depth + 1,sum + x, i + 1) // Check to see if next level + 1 works
            || recurse(depth, sum, i + 1);       // Check to see if this level + 1 works
    }

    public static void main(String args[]){
        // Create instance
        new AssignmentThree();
    }
}
