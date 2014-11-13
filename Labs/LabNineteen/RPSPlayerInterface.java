/**
* Interface according to specs. Seems pretty weird to have 
* single nstance of this coupled with an abstract class, but 
* I'll stick to the assignment 
*/
public interface RPSPlayerInterface{
	public int getPoints();
	public String getGesture();
	public void setPoints(int aPoints);
	public void setGesture(String aGesture);
	public void chooseGesture();
}