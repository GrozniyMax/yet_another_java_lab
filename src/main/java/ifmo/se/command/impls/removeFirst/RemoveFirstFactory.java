package ifmo.se.command.impls.removeFirst;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandExecutor;
import ifmo.se.command.CommandFactory;

/**
 * Фабрика команды {@code remove_first}
 */
public class RemoveFirstFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    public RemoveFirstFactory(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }


    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new RemoveFirst(collectionManager);
    }

    @Override
    public String getSupportedCommand() {
        return "remove_first";
    }
}
