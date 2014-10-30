
/**
 * Just a Diamond class
*/

public class Diamond extends ShapeBasics implements DiamondInterface{
    private int width = 0;

    public Diamond(){}

    public Diamond(int theOffset){
        super(theOffset);
    }

    // You are calling this wrong in the Driver.
    public Diamond(int theWidth,int theOffset){
        super(theOffset);
        setWidth(theWidth);
    }

    public void setWidth(int newWidth){
        width = newWidth;
    }
    public int getWidth(int newWidth){
        return width;
    }

    /**
     * Draws the shape at lineNumber lines down
     * from the current line.
    */
    public void drawAt(int lineNumber){
        for (int count = 0; count < lineNumber; count++)
            System.out.println( );
        drawHere( );
    }

    /**
     * Draws the shape at the current line.
    */
    public void drawHere(){
        drawTopV();
        drawBottomV();
    }

    // So if functional programming was a thing doing it 
    // like this would be even more crazy
    private void drawBottomV(){
        for (int count = width; count > (int)width/2 - 1 + width%2; count--){
            drawRow(-count + width);
        }
    }

    private void drawTopV(){
        for (int count = 1; count < (int)width/2 + 1; count++){
            drawRow((int)width/2 - count + 1);
        }
    }
 
    private void drawRow(int number){
        int spaces = ((int)width/2 - number)*2 - 1;
        spaces += width%2 == 0? -1 : 0;
        if(spaces == -2) return;
        
        skipSpaces(number + getOffset());
        System.out.print('*');
        
        if(spaces >= 0){
            skipSpaces(spaces);
            System.out.print('*');
        }
        System.out.print('\n');
    }

    public static void skipSpaces(int number){
        for (int count = 0; count < number; count++)
            System.out.print(' ');
    }
}