package ifmo.se.command.impls.clear;

import ifmo.se.CollectionManager;
import ifmo.se.command.Command;

/**
 * Команда {@code clear}
 */
public class Clear implements Command {

    private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.getCollections().clear();
    }
}
