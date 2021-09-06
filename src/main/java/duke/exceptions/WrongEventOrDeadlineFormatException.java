package duke.exceptions;

/**
 * Class that handles Event or Deadline commands
 * without a date or time input.
 */
public class WrongEventOrDeadlineFormatException extends DukeException {

    /**
     * Throws standard error when time or date element
     * in event/ deadline command is not found.
     */
    public WrongEventOrDeadlineFormatException() {
        super("Event or Deadline task requires a date and time input!");
    }
}
