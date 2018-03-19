package startup;


import controller.Controller;
import view.View;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Controller controller = new Controller();
        View view = new View(controller);

        view.operationLoop();
    }
}
