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

    public void getAllCommands () {
        commands.showAll();
    }

    public String getInspectionNumber () {
        String regNumber;

        printView.printInput("Please enter a valid registration number.");

        return regNumber = reader.nextLine();
    }

    public CreditCardDTO getCreditCardNumber () {

        String creditCardNumber;
        boolean correctNumber = true;

        while (correctNumber) {

            printView.printInput("Please enter your credit card number. \n Press number 1!");

            creditCardNumber = reader.nextLine();

            if (creditCardNumber.equals("1")) {
                return new CrediCardDTO(1234, "SKJG122344JIF", 1200.54 , "12/04/2020", 174);
            } else {
                printView.printMessage("Please press number 1");
            }
        }


    }

}
