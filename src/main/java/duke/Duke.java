package duke;

import duke.commands.Command;
import java.io.FileNotFoundException;
import duke.exceptions.DukeException;
import javafx.application.Platform;

/**
 * Duke object class. Contains methods to run the duke bot.
 */
public class Duke {
    private final Parser parser;
    private Storage storage;
    private Ui ui;
    private TaskList tasks;


    /**
     * Instantiates Parser, Storage, Ui and Tasklist and passes the filepath to storage class
     * catches both exceptions from storage class. If either 1 exception happens,
     * Tasklist is initialized as empty, with no tasks in it.
     * 
     * @param filePath String containing the relative file path 
     * that storage class takes in to store and read tasks
     */
    public Duke(String filePath) {
        parser = new Parser();
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException | FileNotFoundException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * gives the starting welcome message
     * @return String welcome message
     */
    public String getWelcomeMessage() {
        return ui.showWelcomeMsg();
    }

    /**
     * Retrieves the response of the bot given the input command by user.
     * Interacts with the different classes to achieve the bot behaviour.
     * Run stops when a "bye" command is entered and ends the bot processes.
     * 
     */
    public String run(String fullCommand) {
        try {
            Command c = parser.parse(fullCommand);
            String outputMessage = c.execute(tasks, ui, storage);
            if (c.isExit()) {
                Platform.exit();
            }
            return outputMessage;
        } catch (DukeException e) {
            return ui.displayErrorMessage(e.getMessage());
        }
    }


}
