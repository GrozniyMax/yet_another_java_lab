package ifmo.se.command.impls.show;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

import java.io.PrintStream;

/**
 * Фабрика команды {@code show}
 */
public class ShowFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    private final PrintStream out;

    public ShowFactory(CollectionManager collectionManager, PrintStream out) {
        this.collectionManager = collectionManager;
        this.out = out;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new Show(collectionManager, out);
    }

    @Override
    public String getSupportedCommand() {
        return "show";
    }
}
