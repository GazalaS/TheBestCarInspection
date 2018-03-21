package view;

/**
 * <code>enum</code> of valid commands that represent application functions.
 */

public enum CommandWord {

    NEXT("next"), COST("cost"), PAY("pay"), INSPECTION("inspection"), HELP("help"), QUIT("quit"), UNKNOWN("?");


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
