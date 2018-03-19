package startup;


import controller.Controller;
import view.View;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Controller controller = new Controller();
        View view = new View(controller);
    }
}
