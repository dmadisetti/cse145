/**
* @author  Dylan Madisetti
* @version 1.0, Sept 25, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;

public class LabTen{

    //  Init my scanner
    private Scanner scanner = new Scanner(System.in);
    private int[] ordered, unordered;
    private int length;

    // Constructors are constructorful
    public LabTen(){
        System.out.println("Welcome to the insertion sorter\n"); // Print obligatory nonsense
        System.out.println("Please enter the number of values you would like to sort");
        length = scanner.nextInt();
        unordered = ordered = new int[length];
        for (int i =0; i < length; i++) {
            System.out.println("Please enter the number at "+ i);
            unordered[i] = scanner.nextInt();
        }

        // insertion sort
        for (int i = 0; i < length; i++) {
            int j = i;
            while (j > 0 && ordered[j] <= ordered[j-1]){
                // Swap them
                int temp = ordered[j - 1];
                ordered[j - 1] = ordered[j];
                ordered[j--] = temp;
            }
        }

        regurgitate(unordered,false);
        regurgitate(ordered,true);

        System.out.println("DONE!"); // Done
    }

    private void regurgitate(int[] list, boolean ordered){
        System.out.println("The " + (ordered? "" : "un") + "sorted array is");
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    // Entry point
    public static void main(String[] args) {
        // Start it off
        new LabTen();
    }
}