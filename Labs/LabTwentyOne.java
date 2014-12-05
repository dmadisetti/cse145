/**
* @author  Dylan Madisetti
* @version 1.0, Dec 5, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;

public class LabTwentyOne{

    //  Init my scanner
    private Scanner scanner = new Scanner(System.in);
    private String[][] words = {{"length","height"},{"first","second"}};

    // Constructors are constructorful
    public LabTwentyOne(){
        System.out.println("Welcome to the matrix multiplier program\n"); // Print obligatory nonsense
        System.out.println( // print string of matrix addtion
            process( // create string of matrix additon
                populate("1",new int[(size(1,0))][(size(0,0))])  // create matrix from user prompt
                ,populate("2",new int[(size(1,1))][(size(0,1))]) // create another matrix from prompt
            )
        );
        System.out.println("DONE!"); // Done
    }

    // add any number of matrices
    private String process(int[][] a, int[][] b){
        // default to numbers that shouldn't exist
        int length = -1;
        int width = -1;
        int cell = 0;
        String sSum = ""; // string to write the sums
        int[][] product; // matrix to hold the sums


        // Pukes on 0 values. Can't have a dimensionless matrix
        try{

	        // Check matrices to see if they are compatible.
	        if (a[0].length !=  b.length){
	        	return "Please only multiply nxm with mxp";
	        }

            // zeroed, which is nice
            product = new int[a.length][b[0].length];

        }catch (ArrayIndexOutOfBoundsException e){
            return "Malformed matrices. Require dimensions.";
        }

        // for each column, row add em
        for (int y =0; y < product.length; y++) {
            for (int x =0; x < product[y].length; x++) {
	            for (int j = 0; j < b.length; j++) {
	                // running total the product
	                product[y][x] += a[y][j] * b[j][x];
	            }
	    		sSum += product[y][x] + " ";
    		}
            // new line to the product
            sSum += "\n";
        }

        // This guy equals...
        return "\n" + stringify(a) + "X\n" + stringify(b) + "=\n" + sSum;
    }


    private String stringify(int[][] m){
    	String string = "";
        // for each column, row add em
        for (int y =0; y < m.length; y++) {
            for (int x =0; x < m[y].length; x++) {
	    		string += m[y][x] + " ";
    		}
            // new line to the string
            string += "\n";
        }
        return string;
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
        new LabTwentyOne();
    }
}