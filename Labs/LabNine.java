/**
* @author  Dylan Madisetti
* @version 1.0, Sept 22, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;
import java.util.Arrays;

public class LabNine{

    //  Init my scanner
    private Scanner scanner = new Scanner(System.in);
    private String[][] words = {{"length","height"},{"first","second"}};

    // Constructors are constructorful
    public LabNine(){
        System.out.println("Welcome to the matrix adder program\n"); // Print obligatory nonsense
        System.out.println( // print string of matrix addtion
            process(new int[][][]{ // create string of matrix additon
                populate("1",new int[(size(1,0))][(size(0,0))])  // create matrix from user prompt
                ,populate("2",new int[(size(1,1))][(size(0,1))]) // create another matrix from prompt
            })
        );
        System.out.println("DONE!"); // Done
    }

    // add any number of matrices
    private String process(int[][][] matrices){
        // default to numbers that shouldn't exist
        int length = -1;
        int width = -1;

        String sEquation = ""; // string to write the equation
        String sSum = ""; // string to write the sums
        int[][] sum; // matrix to hold the sums

        // Pukes on 0 values. Can't have a dimensionless matrix
        try{
            // zeroed, which is nice
            sum = new int[matrices[0].length][matrices[0][0].length];
        }catch (ArrayIndexOutOfBoundsException e){
            return "Malformed matrix. Requires dimension.";
        }

        // For each matrix, add em
        for (int i =0; i < matrices.length; i++) {

            // Check each matrix to see if they match
            if(length < 0){
                length = matrices[i].length;
                width = matrices[i][0].length;
            } else if (length != matrices[i].length || width != matrices[i][0].length)
                return "Cannot add these!  Dimension mismatch";

            // Just a boolean to hold is last
            boolean last = i + 1 == matrices.length;

            // for each column, row add em
            for (int y =0; y < matrices[i].length;y++) {
                for (int x =0; x < matrices[i][y].length;x++) {
                    sEquation += matrices[i][y][x] + " ";
                    // running total the sum and add to string if last
                    sum[y][x] += matrices[i][y][x];
                    if(last) sSum += sum[y][x] + " ";
                }
                // new line to the equation
                sEquation += "\n";
                if(last) sSum += "\n";
            }
            // are we still adding? or does it equal?
            sEquation += last ? "=\n" : "+\n";
        }
        return "\n" + sEquation + sSum;
    }

    // Left as a string because no reason I can't name my matrix Bob
    private int[][] populate(String name, int[][] matrix){
        System.out.println("---");
        for (int y =0; y < matrix.length;y++) {
            for (int x =0; x < matrix[y].length;x++) {
                System.out.println("Please enter a value for matrix " + name + " space "+ (x + 1) +"," + (y + 1));
                matrix[y][x] = scanner.nextInt();
            }            
        }
        System.out.println("---------------------\n");
        return matrix;
    }

    // prompt user for specified dimension and order
    private int size(int dimension, int order){
        System.out.println("Please enter the " + words[0][dimension] + " of the "+ words[1][order] +" matrix"); // prompt for dimenions
        return scanner.nextInt();
    }

    // Entry point
    public static void main(String[] args) {
        // Start it off
        new LabNine();
    }
}
