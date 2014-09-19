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

// Notes on this:
// I was hoping for tail recursion optimization, but java doesn't do that.
// Here's a dissection from javap: 
//
//  private boolean recurse(int, int, int);
//    Code:
//       0: iload_1       
//       1: iconst_3      
//       2: if_icmpgt     16
//       5: iload_3       
//       6: iload_3       
//       7: imul          
//       8: sipush        200
//      11: iload_2       
//      12: isub          
//      13: if_icmple     18
//      16: iconst_0      
//      17: ireturn       
//      18: iload_3       
//      19: iload_3       
//      20: imul          
//      21: istore        4
//      23: aload_0       
//      24: getfield      #4                  // Field answers:[I
//      27: iload_1       
//      28: iload_3       
//      29: iastore       
//      30: iload_2       
//      31: iload         4
//      33: iadd          
//      34: sipush        200
//      37: if_icmpeq     69
//      40: aload_0       
//      41: iload_1       
//      42: iconst_1      
//      43: iadd          
//      44: iload_2       
//      45: iload         4
//      47: iadd          
//      48: iload_3       
//      49: iconst_1      
//      50: iadd          
//      51: invokespecial #5                  // Method recurse:(III)Z
//      54: ifne          69
//      57: aload_0       
//      58: iload_1       
//      59: iload_2       
//      60: iload_3       
//      61: iconst_1      
//      62: iadd          
//      63: invokespecial #5                  // Method recurse:(III)Z
//      66: ifeq          73
//      69: iconst_1      
//      70: goto          74
//      73: iconst_0      
//      74: ireturn       
//
// Ideally instuctions 51 and 63 should be gotos instead of pushing another function on the stack
// Futher reading shows that java purposefully doesn't tail recurse. Why? I don't know, reading 
// online shows that Oracle doesn't care enough to do it. However, it's what's keeping me from 
// setting TARGET = 1000000 and not worrying about a stackoverflow. It should be coming in some 
// version of 8
