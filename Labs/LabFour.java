import java.util.Scanner;

// Rebel Lab!
// Purpose of this was to use conditionals, and/ or operators
// Let's not do any of that but still have a functioning program
// If we used java 8 I would have wrapped the tenary in a lambda function

public class LabFour{
    public static void main(String[] args) {
        System.out.println("Welcome to the leap year program! Enter a year in yyyy format"); // Start it off
        int x = (new Scanner(System.in)).nextInt() % 400; // Brings it to 0 if divisible by 400, thus making it work below
        System.out.println("That is" + (((x - 1) % 100 + x % 4 == x % 100 - 1) ? " " : " NOT ") + "a leap year!"); // -1 brings to 99 if divisible by 100, x % 4 adds nothing if divisible by 4
    }
}
