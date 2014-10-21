/**
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

public class Beer{

	private String name;
	private double content;

    public Beer(String aName, double aContent){
    	name = aName;
    	if(content < 0 || content > 1){
    		System.out.println("Bad");
    		System.exit(0);
    	}
    	content = aContent;
    }

	public double toIntoxication(double weight){
		return (0.08 + 0.015) * weight / (12.0 * 7.5 * content);
	}

	public String toString(){
		return name;
	}
}