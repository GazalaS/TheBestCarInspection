package view;

/**
 * Holds the command word entered by user
 */

public class Command {

    private CommandWord commandWord;

    public Command (CommandWord commandWord) {

        this.commandWord = commandWord;
    }

    public CommandWord getCommandWord() {
        return commandWord;
    }

    /**
     * Checks if the first word in the <code>Command</code> is <code>UNKNOWN</code>
     * @return code>true</code> if the first word is <code>UNKNOWN</code> and <code>false</code> if it is not
     */

    public boolean isUnknown() {

        return (commandWord == commandWord.UNKNOWN);
    }


}


