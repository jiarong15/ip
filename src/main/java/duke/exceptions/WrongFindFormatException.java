package duke.exceptions;

/**
 * Class that handles find command in a wrong format.
 */
public class WrongFindFormatException extends DukeException {

    /**
     * Throws error when find command isn't accompanied
     * with a body to specify the task to find.
     */
    public WrongFindFormatException() {
        super("Find command requires a description of what you want to find!");
    }

}
