package ifmo.se.command.impls.clear;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandExecutor;
import ifmo.se.command.CommandFactory;

/**
 * Фабрика команды {@code clear}
 */
public class ClearFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    public ClearFactory(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new Clear(collectionManager);
    }

    @Override
    public String getSupportedCommand() {
        return "clear";
    }
}
