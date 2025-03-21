package ifmo.se.command.impls.help;

import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

import java.io.PrintStream;

/**
 * Фабрика команды {@code help}
 */
public class HelpFactory implements CommandFactory {

    private final PrintStream out;

    public HelpFactory(PrintStream out) {
        this.out = out;
    }


    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new HelpCommand(out);
    }

    @Override
    public String getSupportedCommand() {
        return "";
    }
}
