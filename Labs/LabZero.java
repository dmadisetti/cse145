import java.io.InputStream;
import java.util.Scanner;

public class LabZero{
    public static void main(String[] args) {

        System.out.println("Volume Computer");
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What's the Mass?");
        double mass = keyboard.nextDouble();
        System.out.println("What's the Density?");
        double density = keyboard.nextDouble();
        double volume = mass / density;

        System.out.println("The Volume is:" + volume);
    }
}