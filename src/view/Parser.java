package view;

import integration.CreditCardDTO;

import java.time.YearMonth;
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

        printView.printInput("");
        inputLine = reader.nextLine();

        return new Command(commands.getCommandWord(inputLine));
    }

    /**
     * Shows every valid command
     */

    public void getAllCommands () {
        commands.showAll();
    }

    /**
     * Takes inspection number from the user
     * @return Returns the inspection number user entered
     */

    public String getInspectionNumber () {
        String regNumber;

        printView.printInput("Please enter a valid registration number.");

        return regNumber = reader.nextLine();
    }

    /**
     * Takes the credit card data from user input.
     * @return Returns credit card object.
     */

    public CreditCardDTO getCreditCardNumber () {

        CreditCardDTO creditCardNumber = null;
        String creditCardNumberInput;
        boolean correctNumber = true;

        while (correctNumber) {

            printView.printInput("Please enter your credit card number. \n Press number 1!");

            creditCardNumberInput = reader.nextLine();

            if (creditCardNumberInput.equals("1")) {

                creditCardNumber = new CreditCardDTO(1234, "SKJG122344JIF", "Nino Prekratic" ,  YearMonth.parse("2020-12"), 174);
                printView.printMessage("Credit card input successfully!");
                correctNumber = false;

            } else {
                printView.printMessage("Please press number 1");
            }
        }
        return creditCardNumber;
    }

    /**
     * Gets the inspection result from the user - valid inputs are <code>pass</code> or <code>fail</code>
     * @return Return the inspection result
     */

    public String inspectionResult () {

        String inspectionResult = null;
        boolean success = false;

        while (!success) {

        printView.printInput("What is the result of the inspection? \nAccepted input is \"pass\" or \"fail\".");

            inspectionResult = reader.nextLine();

            if (inspectionResult.equals("pass") || inspectionResult.equals("fail")) {
                success = true;
            } else {
                printView.printMessage("Your input is wrong.");
            }
        }
        return inspectionResult;
    }
}
