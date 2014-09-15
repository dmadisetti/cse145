/**
* AssignmentTwo: Asks user for some triangle side. Runs triangle analysis
* Covers: is triangle, is isosceles, is equalateral, is right, the area, the perimeter
* .__            __            
* |  |__ ___  __|  | __  ______
* |  |  \\  \/  /  |/ / /  ___/
* |   Y  \>    <|    <  \___ \ 
* |___|  /__/\_ \__|_ \/____  >
*     \/      \/    \/     \/ 
* Hacked together by Dylan Madisetti
*
* @author  Dylan Madisetti
* @version 1.0, Sept 12, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/
import java.io.InputStream;
import java.util.Scanner;

public class AssignmentTwo{

	private Scanner scanner = new Scanner(System.in);  // packaged class to read stdin
	private int side = 1; // variable to display for prompts
	private Triangle triangle; // Our triangle instance

	// Triangle class to hold helper triangle methods and order sides
	private class Triangle{
		private double max;
		private double mid;
		private double min;
		public Triangle(double a, double b, double c){
			max = Math.max(c,Math.max(a,b)); // the best of the best
			min = Math.min(c,Math.min(a,b)); // The lowest of the low
			mid = Math.max(Math.min(c,Math.max(a,b)),Math.min(a,b)); // the best of the low and the lowest of the best
		}

		public boolean isTriangle(){
			// but does it close?
			return mid + min > max;
		}
		public boolean isRight(){
			// Pythag
			return Math.pow(min,2) + Math.pow(mid,2) == Math.pow(max,2);
		}
		public boolean isEquilateral(){
			// Squeeze
			return min == max;
		}
		public boolean isIsosceles(){
			// Mid is equal to what?
			return mid == min || mid == max;
		}
		public double getArea(){
			// Heron's formula
			double s = getPerimeter()/2;
			return Math.sqrt(s * (s - min) * (s - mid) * (s - max));
		}
		public double getPerimeter(){
			// Just add em up
			return min + mid + max;
		}
	}

	// Constructor to start Password Checker
	private AssignmentTwo(){
		// Output ma name
		System.out.println("Welcome to the Triangle Program\n");

		// Ask for each side and build triangle from input
		triangle = new Triangle(prompt(),prompt(),prompt());

		// Print out some stuff about the triangle	
		System.out.println("\nMy analysis of this triangle is:\n");
		regurgitate(triangle.isTriangle(),"",true); // Is this even a triangle? If it isn't just leave. Just go.
		regurgitate(triangle.isRight()," right",false); // If being isosceles is wrong, then I don't want to be right.
		regurgitate(triangle.isEquilateral(),"n equilateral",false); // All triangles are equal, but some are more equal than others.
		if(!triangle.isEquilateral()) regurgitate(triangle.isIsosceles(),"n isosceles",false); // The lowest of all flatland.
		System.out.println("The area of the triangle is " + triangle.getArea()); // Not a red Heron
		System.out.println("The perimeter of the triangle is " + triangle.getPerimeter()); // Add em up
	}

	// Just to grab user input
	private double prompt(){
		System.out.println("Please enter the length of side " + side++);
		return scanner.nextDouble();
	}

	// Same structure for all strings, so let's methodize it
	private void regurgitate(boolean is, String type, boolean fatal){
		System.out.println("This is " + (is? "" : "NOT ") + "a" + type + " triangle.");
		// if not a triangle may as well quit
		if(fatal && !is) System.exit(1);
	}

	public static void main(String args[]){
		// Create instance
		new AssignmentTwo();
	}
}
