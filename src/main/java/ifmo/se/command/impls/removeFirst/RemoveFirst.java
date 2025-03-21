package ifmo.se.command.impls.removeFirst;

import ifmo.se.CollectionManager;
import ifmo.se.command.Command;

/**
 * Команда {@code remove_first}
 */
public class RemoveFirst implements Command {

    private final CollectionManager collectionManager;

    public RemoveFirst(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.getCollections().remove(0);
    }
}
