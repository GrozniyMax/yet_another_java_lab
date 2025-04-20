package ifmo.se.command.impls.add;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

import java.io.PrintStream;

/**
 * Фабрика команды {@code add}
 */
public class AddFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    private final PrintStream out;

    public AddFactory(CollectionManager collectionManager, PrintStream out) {
        this.collectionManager = collectionManager;
        this.out = out;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new Add(collectionManager, input, out);
    }

    @Override
    public String getSupportedCommand() {
        return "";
    }
}
