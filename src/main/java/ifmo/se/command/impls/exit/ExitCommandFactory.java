package ifmo.se.command.impls.exit;

import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

/**
 * Фабрика команды {@code exit}
 */
public class ExitCommandFactory implements CommandFactory {
    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new Exit();
    }

    @Override
    public String getSupportedCommand() {
        return "exit";
    }
}
