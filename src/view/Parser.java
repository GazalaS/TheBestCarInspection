package view;

import java.util.Scanner;

public class Parser {

    private CommandWords commands;
    private PrintView printView;
    private Scanner reader;

    public Parser () {

        commands = new CommandWords();
        printView = new PrintView();
        reader = new Scanner(System.in);
    }

    /**
     * Reads user input and takes first two words in order to create a <code>Command</code> object.
     *
     * @return New command detected from user input.
     */

    public Command getCommand() {
        String inputLine;
        String word1 = null;

        printView.printInput("");

        inputLine = reader.nextLine();

        Scanner tokanizer = new Scanner(inputLine);

        if (tokanizer.hasNext()) {

            word1 = tokanizer.next();
        }

        return new Command(commands.getCommandWord(word1));
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

        commands.showAll();
    }
}
