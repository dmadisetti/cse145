/**
* AssignmentSeven: Test thingy
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
* @version 1.0, Sept 25, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

// For assertions
// java -ea AssignmentSeven
public class AssignmentSeven{

    // Constructor to start 
    private AssignmentSeven(){
        System.out.println("\"Testing\" the Doctor Class");

        System.out.println("Creating Doctor via default constructor");
        Doctor a = testDefaultDoctor();
        a.regurgitate();
        
        System.out.println("Changing default Doctor's name, specialty, and fee via mutators.");
        Doctor b = testMutatedDoctor("Tom Baker","Time Lord", 4.95);
        b.regurgitate();

        System.out.println("Creating Doctor via parameterized constructor");
        Doctor c = testDoctor("Albert W. Wiley","Robotics", 1987);
        c.regurgitate();
        
        System.out.println("Testing if the two doctors are equal.");
        assert !b.equals(c);
        System.out.println("False\n");
        
        System.out.println("Done!");
    }

    private void check(Doctor d,String name, String specialty, double fee){
        // if we were really testing
        assert d.getName().equals(name);
        assert d.getSpecialty().equals(specialty);
        assert d.getFee() == fee;
    }

    private Doctor testDefaultDoctor(){
        Doctor d = new Doctor();
        check(d, "No name yet", "None",0.0);
        return d;
    }

    private Doctor testMutatedDoctor(String name, String specialty, double fee){
        Doctor d = new Doctor();

        // Set stuffs
        d.setName(name);
        d.setSpecialty(specialty);
        d.setFee(fee);

        // Check em
        check(d,name,specialty,fee);
        return d;
    }

    private Doctor testDoctor(String name, String specialty, double fee){
        // Create em
        Doctor d = new Doctor(name,specialty,fee);

        // Check em
        check(d,name,specialty,fee);
        return d;
    }

    // Entry point
    public static void main(String args[]){
        // Create instance
        new AssignmentSeven();
    }
}