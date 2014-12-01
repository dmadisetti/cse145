
public class LightsaberTester {
	public static void main(String[] args)
	{
		System.out.println("To become a Jedi, one must build a lightsaber.  Let's test to see if you have constructed yours properly");
		
		System.out.println("Testing constructors");
		String color = "green";
		boolean isOn = false;
		double bladeLength = 145;
		Lightsaber aSaber = new Lightsaber(color, isOn, bladeLength);
		
		if(color.equals(aSaber.getColor()) && isOn == aSaber.getIsOn() && bladeLength == aSaber.getBladeLength())
		{
			System.out.println("This saber has passed the first test!");
		}
		else
		{
			System.out.println("This saber was not constructed properly");
		}
		
		System.out.println("Testing incorrect color values");
		aSaber.setColor("brown");
		if(color.equals(aSaber.getColor()))
		{
			System.out.println("This has passed test two!");
		}
		else
		{
			System.out.println("This failed and the saber was set to a stupid color");
		}
		
		System.out.println("Testing incorrect size values");
		aSaber.setBladeLength(10);
		if(bladeLength == aSaber.getBladeLength())
		{
			System.out.println("This has passed test three!");
		}
		else
		{
			System.out.println("This failed and the saber is too short");
		}
		aSaber.setBladeLength(170.0);
		if(bladeLength == aSaber.getBladeLength())
		{
			System.out.println("This has passed test four!");
		}
		else
		{
			System.out.println("This failed and the saber is unwieldy");
		}
		
		System.out.println("Testing to see if this can be duplicated");
		Lightsaber anotherSaber = new Lightsaber(color, isOn, bladeLength);
		if(aSaber.equals(anotherSaber))
		{
			System.out.println("This passed test five!  They can be duplicated");
		}
		else
		{
			System.out.println("This failed");
		}
		
		System.out.println("Finally let's test out your blade");
		aSaber.setIsOn(true);
		if(aSaber.getIsOn() == true)
		{
			System.out.println("BB-ZSHOOOO");
			System.out.println("You have a working lightsaber.  Now you are a jedi");
		}
		else
		{
			System.out.println("Your light saber is broked.  Go back to the moisture vaporators n00b");
		}
		
	}
}
