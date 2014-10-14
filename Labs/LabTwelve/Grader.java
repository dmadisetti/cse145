/**
* @author  Dylan Madisetti
* @version 1.0, Oct 14, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;
import java.util.HashMap;

public class Grader{

    private Scanner scanner = new Scanner(System.in); //  Init my scanner
    private double grade = 0;
    private char gradeLetter;

    // Finals?
    private static final double QUIZ_WEIGHT = 0.125;
    private static final double MIDTERM_WEIGHT = 0.25;
    private static final double FINAL_WEIGHT = 0.50;

    // Let's make this guys final and set it up. Not going to change
    private static final Grade[] GRADES = new Grade[]{
         new Grade(QUIZ_WEIGHT,"quiz 1")
        ,new Grade(QUIZ_WEIGHT,"quiz 2")
        ,new Grade(MIDTERM_WEIGHT,"midterm")
        ,new Grade(FINAL_WEIGHT,"final exam")
    };

    // Woo! Let's do another class to show we know what we're about    
    private static class Grade{

        // Don't look at my privates
        private double weight;
        private double score;
        private String name;

        // Constructors are constructorful
        public Grade(double aWeight, String aName){
            this.weight = aWeight;
            this.name = aName;
        }

        // Mutators? I've always called them setters
        public void setScore(double aScore){
            if (aScore > 100.0){
                System.out.println("Too big. Exiting");
                System.exit(0);
            }
            this.score = aScore;
        }

        // Getters
        public String getName(){
            return this.name;
        }
        public double getPercentage(){
            return this.weight * this.score;
        }
    }

    // Constructors are constructorful
    public Grader(){}

    // This incredibly ridiculous.
    public void setQuiz1(){
        prompt(0);
    }
    public void setQuiz2(){
        prompt(1);
    }
    public void setMidtermExam(){
        prompt(2);
    }
    public void setFinalExam(){
        prompt(3);
    }

    // Ask user for particular grade
    private void prompt(int index){
        Grade g = GRADES[index];
        System.out.println("Enter the score for " + g.getName());
        g.setScore(scanner.nextDouble());
    }

    // Could hae done this while prompting, but since there is an explicit function call, let's be explicit
    public void calculateFinalGrade(){
        for(int i = 0; i < GRADES.length; i++){
            grade += GRADES[i].getPercentage();
        }
        gradeLetter = determineGrade();
    }

    // Switch it up
    private char determineGrade(){
        switch((int)(grade/10)){
            case 6:
                return 'D';
            case 7:
                return 'C'; 
            case 8:
                return 'B'; 
            case 9:
            case 10:
                return 'A';
            default:
                return 'F';
        }
    }

    // Regurgitate
    public void printFinalGrade(){
        System.out.println("The final grade is");
        System.out.println(grade);
        System.out.println(gradeLetter);
    }
}