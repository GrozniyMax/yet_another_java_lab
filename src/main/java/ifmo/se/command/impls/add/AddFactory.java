package ifmo.se.command.impls.add;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

/**
 * Фабрика команды {@code add}
 */
public class AddFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    public AddFactory(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new Add(collectionManager, input);
    }

    @Override
    public String getSupportedCommand() {
        return "";
    }
}
