package startup;


import controller.Controller;
import view.View;

import java.io.IOException;


public class Main {

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
