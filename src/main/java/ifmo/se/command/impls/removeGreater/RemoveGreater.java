package ifmo.se.command.impls.removeGreater;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.model.Flat;

/**
 * Команда {@code remove_greater}
 */
public class RemoveGreater implements Command {

    private final CollectionManager collectionManager;

    private final CommandLineReader reader;

    public RemoveGreater(CollectionManager collectionManager, CommandLineReader reader) {
        this.collectionManager = collectionManager;
        this.reader = reader;
    }

    @Override
    public void execute() {
        Flat toCompare = reader.readFlat();

        collectionManager.getCollections().removeIf(f -> f.compareTo(toCompare) > 0);
    }
}
