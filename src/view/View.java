package view;

import controller.Controller;

public class View {

    private Controller controller;
    private String regNumber;
    private double inspectionCost;
    private Parser parser;
    private PrintView printView;
    private boolean cardAuthoriztion;

    public View (Controller controller) {

        this.controller = controller;
        parser = new Parser();
        printView = new PrintView();
        cardAuthoriztion = false;
    }

    /**
     * Main application loop
     */

    public void operationLoop() {

        boolean finished = false;

        getPrintStart();
        showCommands();

        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        getPrintExit();
    }

    /**
     * Analyses the <code>Command</code> received from the user and calls appropriate function.
     *
     * @param command - command inputted by the user.
     * @return If the <code>quit</code> command is detected returns <code>true</code>, if not returns <code>false<code/>.
     */

    public boolean processCommand(Command command) {

        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {

            case UNKNOWN:
                printView.printMessage("This is unknown");
                break;

            case NEXT:
                printView.printMessage("Start new inspection!");
                startInspection();
                break;

            case OPEN:
                printView.printMessage("Open the door.");

                break;

            case CLOSE:
                printView.printMessage("Close the door.");

                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    /**
     * Performs <code>quit</code> command and quits the application
     *
     * @param command - receives <code>quit</code> command
     * @return true if it is only <code>quit</code> command
     */

    private boolean quit(Command command) {

        return true;
    }

    /**
     * Prints out welcome message
     */

    public void getPrintStart() {

        printView.printMessage("Welcome to THE BEST CAR INSPECTION  app");
        printView.printMessage("---------------------------------------");
    }

    /**
     * Prints out quit message
     */

    public void getPrintExit() {

        printView.printMessage("Thank for using THE BEST CAR INSPECTION app");
        printView.printMessage("-------------------------------");
    }

    /**
     * Prints out all valid commands
     */

    public void showCommands() {

        printView.printMessage("Available commands are: ");
        System.out.println();

        parser.getAllCommands();
        System.out.println();
    }

    /**
     * Starts a new inspection by calling a function in the controller
     */

    private void startInspection () {

        regNumber = parser.getInspectionNumber();
        controller.startNewInspection();
    }

    private void getInspectionCost () {
        inspectionCost = controller.getInspectionCost();
    }

    private boolean paymentByCreditCard () {
        String creditCardNumber;



        cardAuthoriztion = controller.authorizePayment(creditCardNumber);
    }

    private void inspection () {


    }

    private void inspectionCompleted () {


    }

}
