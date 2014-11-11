
/**
 * Just a Square class
*/

public class Square{
    private int length = 0;
    private String side = "";

    public Square(){}

    // Setter for Length
    public void setLength(int newLength) throws DimensionException{

        // Throw if bad dimension
        if(newLength < 1) throw new DimensionException();

        // Set length
        length = newLength;

        // Create a side so we run in n time and not n^2
        side = "";
        for (int i = 0; i < length; i++ ) {
            side += "*";
        }
    }

    // Draws the shape from the current line.
    public void draw(){
        for (int i = 0; i < length; i++ ) {
            System.out.println(side);
        }
    }

    // Return area
    public int getArea(){
        return length * length;
    }

    // return perimeter
    public int getPerimeter(){
        return length * 4;
    }

}