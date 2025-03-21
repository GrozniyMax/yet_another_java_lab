package ifmo.se.command.impls.filterStartsWith;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

import java.io.PrintStream;

/**
 * Фабрика команды {@code filter_starts_with}
 */
public class FilterStartsWithFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    private final PrintStream out;

    public FilterStartsWithFactory(CollectionManager collectionManager, PrintStream out) {
        this.collectionManager = collectionManager;
        this.out = out;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new FilterStartWith(collectionManager, lastText.trim(), out);
    }

    @Override
    public String getSupportedCommand() {
        return "filter_starts_with";
    }
}
