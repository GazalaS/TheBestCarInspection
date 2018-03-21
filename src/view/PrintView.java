package view;

/**
 * <code>{@link PrintView}</code> class hold methods for user output print feedback. It also prints out
 * input prompt with appropriate message.
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
