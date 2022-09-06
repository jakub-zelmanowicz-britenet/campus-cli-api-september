package pl.britenet.cli;

import pl.britenet.cli.command.Command;
import pl.britenet.cli.command.CommandService;
import pl.britenet.cli.command.HelloCommand;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static boolean isRunning = true;

    public static void main(String[] args) {
        CommandService command_service = new CommandService();
        command_service.registerCommand(new HelloCommand());

        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            String command_name = scanner.nextLine();
            Optional<Command> o_command = command_service.getCommand(command_name);

            if (o_command.isPresent()) {
                o_command.get().execute();
            }
            else {
                System.out.println("Unknown command.");
            }
        }
    }

}
