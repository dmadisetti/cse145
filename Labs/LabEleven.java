/**
* @author  Dylan Madisetti
* @version 1.0, Oct 2, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;
import java.util.Random;

public class LabEleven{

    //  Init my scanner
    private Scanner scanner = new Scanner(System.in);
    private int[][] matrix;
    private Random random = new Random();
    private String string = "";
    private int odd = 0;
    private int length;
    private int width;
    private final int RANGE = 10;

    // Constructors are constructorful
    public LabEleven(){
        System.out.println("Let’s determine if a random matrix is odd or not\n"); // Print obligatory nonsense
        length = size("length");
        width = size("width");
        matrix = new int[width][length];

        // Iterate over matrix, count odds and create string
        for (int y =0; y < matrix.length;y++) {
            for (int x =0; x < matrix[y].length;x++) {
                string += matrix[y][x] = random.nextInt(RANGE);
                string += " ";
                odd += matrix[y][x] % 2;
            }
            string += "\n";
        }

        System.out.println(string);
        System.out.println("It is " + (odd*2 > length*width? "" : "not ") + "odd.");        
        System.out.println("Done!"); // Done
    }

    // prompt user for specified dimension
    private int size(String dimension){
        System.out.println("Please enter the " + dimension + " of the matrix"); // prompt for dimenions
        return scanner.nextInt();
    }

    // Entry point
    public static void main(String[] args) {
        // Start it off
        new LabEleven();
    }
}