/**
* AssignmentSeven: A doctor a day, will eventually end in segmentation fault
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
* @version 1.0, Nov 5, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/
public class Doctor extends Person{

    private String specialty = "None";
    private double fee       = 0;
    
    public Doctor(){}
    public Doctor(String aName, String aSpecialty, double aFee){
        setName(aName);
        setSpecialty(aSpecialty);
        setFee(aFee);
    }

    public void setSpecialty(String aSpecialty){
        specialty = aSpecialty;
    }
    public void setFee(double aFee){
        if (aFee < 0){
            throw new IllegalArgumentException("Doctors don't work for free");
        }
        fee = aFee;
    }

    public String getSpecialty(){
        return specialty;
    }
    public double getFee(){
        return fee;
    }

    public void regurgitate(){
        // Pointless for real tests
        System.out.println("Printing Doctor's Information.");
        System.out.println("Name:"+ getName());
        System.out.println("Specialty:"+ getSpecialty());
        System.out.println("Fee:$"+ getFee());
        System.out.println();
    }

    public boolean equals(Doctor d){
        return d.getFee() == getFee() && d.getName().equals(getName()) && d.getSpecialty().equals(getSpecialty());
    }
}
