package pl.britenet.cli.command;

import pl.britenet.cli.Constants;

public class HelloCommand extends Command {

    public HelloCommand() {
        super(Constants.COMMAND_HELLO);
    }

    @Override
    public void execute() {
        System.out.println("Hello World!");
    }
}
