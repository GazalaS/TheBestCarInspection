package view;

/**
 * Prints out the messages from the system and prompt
 */

public class PrintView {

    public void printMessage(String message) {
        System.out.println("\n" + message);
    }

    public void printInput(String message) {
        System.out.println(message + "\n");
        System.out.print("> ");
    }
}
