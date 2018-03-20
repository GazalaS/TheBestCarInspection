package view;

/**
 * List of valid commands that represent application functionalities
 */

public enum CommandWord {

    NEXT("next"), /*OPEN("open"), CLOSE("close"),*/ COST("cost"), PAY("pay"), INSPECTION("inspection"), HELP("help"), QUIT("quit"), UNKNOWN("?");


    private String commandString;

    CommandWord (String commandString) {

            this.commandString = commandString;
    }

    /**
     * @return String value of the valid command
     */

    public String toString() {

            return commandString;
        }

}
