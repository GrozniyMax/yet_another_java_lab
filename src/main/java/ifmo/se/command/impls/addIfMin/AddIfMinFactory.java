package ifmo.se.command.impls.addIfMin;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

/**
 * Фабрика команды {@code add_if_min}
 */
public class AddIfMinFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    public AddIfMinFactory(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new AddIfMin(collectionManager, input);
    }

    @Override
    public String getSupportedCommand() {
        return "add_if_min";
    }
}
