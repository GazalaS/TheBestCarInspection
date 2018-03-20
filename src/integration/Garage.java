/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 * This is a facade to the hardware of the GARAGE, namely the door and the queue
 * number display on the outside wall.
 */
public class Garage {
    private Door door = new Door();
    private QueueNumberDisplay queueNumDisp = new QueueNumberDisplay();

    /**
     * Creates an instance and connects to the door and queue number display.
     */
    public Garage() {
    }

    /**
     * Opens the door and displays the next queue number.
     */
    public void nextCustomer() {
        door.open();
        queueNumDisp.nextNumber();
    }

    /**
     * Closes the door
     */
    public void closeDoor() {
        door.close();
    }
    
     /**
     * Opens the door
     */
    public void openDoor() {
        door.open();
    }

}
