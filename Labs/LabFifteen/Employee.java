/**
* @author  Dylan Madisetti
* @version 1.0, Oct 28, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.Scanner;
import java.util.Random;

public class Employee extends SimplePerson{

    private double salary = 0;
    private String hire = "Not Hired"; // Not using dateTimes because. Just no. Not for this
    private int id = 0;

    public Employee(){
        // Meow
    }

    public Employee(String aName, double aSalary, String aHire, int aId){
        super(aName);
        setSalary(aSalary);
        setHire(aHire);
        setId(aId);
    }

    // Setters
    private void setSalary(double aSalary){
        if (aSalary >= 0){
            salary = aSalary;
        }else{
            // Should throw error
            System.out.println("Wut");
        }
    }
    private void setHire(String aHire){
        hire = aHire;
    }
    private void setId(int aId){
        if (aId >= 0){
            id = aId;
        }else{
            // Should throw error
            System.out.println("Wut");
        }
    }

    // Getters
    public double getSalary(){
        return salary;
    }
    public String getHire(){
        return hire;
    }
    public int getId(){
        return id;
    }

    // Reguritate Nonsense
    public void writeOutput(){
        System.out.println("Name :" + getName());
        System.out.println("Makes " + salary);
        System.out.println("Was hired " + hire);
        System.out.println("ID number is " + id);
    }

    // Check to see if equal
    public boolean equals(Employee person){
        return super.equals((SimplePerson)person)
        && person.getSalary() == salary 
        && person.getHire().equals(hire) 
        && person.getId() == id;
    }
}