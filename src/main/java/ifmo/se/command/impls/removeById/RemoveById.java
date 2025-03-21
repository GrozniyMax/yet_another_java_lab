package ifmo.se.command.impls.removeById;

import ifmo.se.CollectionManager;
import ifmo.se.command.Command;

/**
 * Команда {@code remove_by_id}
 */
public class RemoveById implements Command {

    private final CollectionManager collectionManager;

    private final int index;

    public RemoveById(CollectionManager collectionManager, int index) {
        this.collectionManager = collectionManager;
        this.index = index;
    }

    @Override
    public void execute() {
        collectionManager.remove(index);
    }
}
