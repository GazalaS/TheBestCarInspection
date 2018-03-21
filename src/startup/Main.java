package startup;


import controller.Controller;
import view.View;

import java.io.IOException;

/**
 * Startup class in the application, holds <code>main</code> method. Creates <code>{@link Controller}</code> and
 * <code>{@link Controller}</code> objects.
 */

public class Main {

    /**
     * <code>Main</code> method of the application.
     * @param args Receives command line arguments.
     */

    public static void main(String[] args) {

        Controller controller = new Controller();
        View view = new View(controller);


        try {
            view.operationLoop();
        } catch (IOException e) {

            e.printStackTrace();
            System.out.println(e);

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }
}
