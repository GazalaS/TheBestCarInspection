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

        CreditCardDTO creditCardNumber = null;
        String creditCardNumberInput;
        boolean correctNumber = true;

        while (correctNumber) {

            printView.printInput("Please enter your credit card number. \n Press number 1!");

            creditCardNumberInput = reader.nextLine();

            if (creditCardNumberInput.equals("1")) {

                creditCardNumber = new CreditCardDTO(1234, "SKJG122344JIF", "Nino Prekratic" ,  YearMonth.parse("2020-12"), 174);
                printView.printMessage("Credit card input successfully!");
            } else {
                printView.printMessage("Please press number 1");
            }
        }
        return creditCardNumber;
    }

    public String inspectionResult () {

        String inspectionResult = null;
        boolean success = false;

        while (!success) {

        printView.printInput("What is the result of the inspection? \n Accepted values are **pass** or **fail**");

            inspectionResult = reader.nextLine();

            if (inspectionResult.equals("pass") || inspectionResult.equals("fail")) {
                success = true;
            } else {
                printView.printMessage("Your input is wrong. \n Accepted values are **pass** or **fail**");
            }
        }

        return inspectionResult;




    }

}
