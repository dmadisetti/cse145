/**
* @author  Dylan Madisetti
* @version 1.0, Oct 28, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;
import java.util.Random;

public class SimplePerson{

    private static String name = "No name yet";
    public SimplePerson(){
        // Meow
    }
    public SimplePerson(String aName){
        setName(aName);
    }
    public void setName(String aName){
        name = aName;
    }
    public String getName(){
        return name;
    }
    public void writeOutput(){
        System.out.println("Name: " + getName());
    }
    public boolean hasSameName(SimplePerson person){
        return person.getName().equals(getName());
    }
    public boolean equals(SimplePerson person){
        return hasSameName(person);
    }
}