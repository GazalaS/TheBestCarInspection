package integration;

/**
 * Controls the queuenumber display.
 * This is the only clas updating the display. 
 * @author GazalaS <gazalafshaikh@gmail.com>
 */


public class Display {
    
    /**
     * Connects to the display and shows the number zero.
     */
    public Display(){
        displayNo(0);
    }    
    /**
     * When this method returns, the display is showing the specified number.
     * @param number The number to show.
     */
    public void displayNo(int number){
        System.out.println("The display is now showing: " + number);
    }
}
