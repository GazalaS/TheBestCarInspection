package view;

import controller.Controller;

public class View {

    private Controller controller;
    private String regNumber;
    private double inspectionCost;
    private Parser parser;

    public View (Controller controller) {

        this.controller = controller;
        parser = new Parser();
    }

    public void start() {

        boolean finished = false;

        parser.getPrintStart();
        parser.showCommands();

        while (!finished) {
            Command command = parser.getCommand();
            finished = parser.processCommand(command);
        }
        parser.getPrintExit();
    }

}
