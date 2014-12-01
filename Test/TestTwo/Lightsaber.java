/**
* TestTwo: It's a test! Become one with the force
*
* @author  Dylan Madisetti
* @version 1.0, Nov 18, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/


public class Lightsaber{

    private static final String[] COLORS = new String[]{"green","blue","red","purple"};
    private String color;// = COLORS[0];
    private boolean isOn;// = false;
    private double bladeLength;// = 130.0;


    // Constructors are constructorful
    public Lightsaber(){
    	this(COLORS[0],false,130.0);
    }

    public Lightsaber(String aColor,boolean on, double aBladeLength){
        setColor(aColor);
        setIsOn(on);
        setBladeLength(aBladeLength);
    }


    // Getters
    public String getColor(){
        return color;
    }
    public boolean getIsOn(){
        return isOn;
    }
    public double getBladeLength(){
        return bladeLength;
    }


    // Setters
    public void setColor(String aColor){
        int i;
        for (i = 0; i < COLORS.length ; i++ ) {
        	if(COLORS[i] == aColor.toLowerCase()) break;
        }
        if (i == COLORS.length){
        	System.out.println("There isn't a known crystal that supports that color");
        	return; // guess you don't want us to set anything
        } //throw new Exception("Color not found");
        color = COLORS[i];
    }

    public void setIsOn(boolean on){
    	isOn = on;
    }
    public void setBladeLength(double aBladeLength){
        // Check for validity
        if (aBladeLength > 130 && aBladeLength < 150){
            bladeLength = aBladeLength;
        }else{
        	System.out.println("This is not a correct blade length");
        }
    }

    // Other
    public String toString(){
    	// Just randomness as per description
    	return "Saber is color " + getColor() + " and " + getBladeLength() + " long. It is " + (getIsOn()? "" : "not") + " on" ;
    }

    // But is it equal?
    public boolean equals(Lightsaber ls){
    	return this.isOn == ls.getIsOn() 
    	&& this.bladeLength == ls.getBladeLength() 
    	&& this.color == ls.getColor();
    }
}