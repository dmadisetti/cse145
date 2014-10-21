/**
* AssignmentSix: Gets crunk
*
* .__            __            
* |  |__ ___  __|  | __  ______
* |  |  \\  \/  /  |/ / /  ___/
* |   Y  \>    <|    <  \___ \ 
* |___|  /__/\_ \__|_ \/____  >
*     \/      \/    \/     \/ 
* Hacked together by Dylan Madisetti
*
* @author  Dylan Madisetti
* @version 1.0, Oct 2, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/
import java.util.Scanner;

public class AssignmentSix{

    private Scanner scanner = new Scanner(System.in);  // packaged class to read stdin
    private String[] order = {"first","second","third"};

    public static void main(String args[]){
        new AssignmentSix();
    }

    private AssignmentSix(){
        System.out.println("Let's Party! Responsibly...");
        regurgitate(beerCollection(2),promptWeight());
        System.out.println("Later Tater");
    }

    // I'm just being obnoxious
    private Beer[] beerCollection(int n){
        Beer[] beers = new Beer[n];
        if(n > order.length){
            System.out.println("We don't support this many beers. IAFNAB");
            System.exit(0);
        }
        for (int i = 0;i< n ;i++ ) {
            beers[i] = beerFactory(i);
        }
        return beers;
    }

    // Need a function just for this
    private Beer beerFactory(int index){
        return new Beer(promptName(index),promptContent());
    }

    // Grab beer name
    private String promptName(int index){
        System.out.println("What's the name of the "+ order[index]+" beer?");
        return scanner.nextLine();
    }

    // Grab beer alcohol
    private double promptContent(){
        System.out.println("What's the alcoholic content?");
        return doubler();
    }

    // Grab user weight
    private double promptWeight(){
        System.out.println("What's the weight of the person consuming said beverages?");
        return doubler();
    }

    // http://stackoverflow.com/questions/14898617/scanner-nextline-is-being-skipped
    private double doubler(){
        return Double.parseDouble(scanner.nextLine());
    }

    // I wanted to use a for each
    private void regurgitate(Beer[] beers, double weight){
        for (Beer beer : beers) {
            System.out.println("It would take " + beer.toIntoxication(weight) + " " + beer.toString() + " beers to become intoxicated.");
        }
    }
}