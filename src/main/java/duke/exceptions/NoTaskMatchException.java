package duke.exceptions;

/**
 * Class of exception that handles 
 * find command being unable to find a matching task.
 */
public class NoTaskMatchException extends DukeException {

    /**
     * Throws default error of not being able
     * to find a matching task stored.
     */
    public NoTaskMatchException() {
        super("You have no task matching this description!");
    }
}
