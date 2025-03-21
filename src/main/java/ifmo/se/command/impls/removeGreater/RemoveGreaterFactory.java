package ifmo.se.command.impls.removeGreater;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

/**
 * Фабрика команды {@code remove_greater}
 */
public class RemoveGreaterFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    public RemoveGreaterFactory(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new RemoveGreater(collectionManager, input);
    }

    @Override
    public String getSupportedCommand() {
        return "remove_greater";
    }
}
