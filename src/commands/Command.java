package commands;

public abstract class Command {
    protected String commandName;

    public abstract void execute(String[] args);

    public String getCommand() {
        return commandName;
    }
}
