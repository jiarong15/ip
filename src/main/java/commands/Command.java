package commands;
public abstract class Command implements forStorage {
    protected final String command_description;

    Command(String command_description) {
        this.command_description = command_description;
    }

    public abstract boolean isExecutable();

}
