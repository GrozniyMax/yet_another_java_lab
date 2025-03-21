package ifmo.se.command.impls.removeById;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

/**
 * Фабрика команды {@code remove_by_id}
 */
public class RemoveByIdFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    public RemoveByIdFactory(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }


    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new RemoveById(collectionManager, Integer.parseInt(lastText.trim()));
    }

    @Override
    public String getSupportedCommand() {
        return "remove_by_id";
    }
}
