package ifmo.se.command.impls.updateById;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.model.Flat;

/**
 * Команда {@code update_by_id}
 */
public class UpdateById implements Command {

    private final CollectionManager collectionManager;

    private final int index;

    private final CommandLineReader reader;

    public UpdateById(CollectionManager collectionManager, int index, CommandLineReader reader) {
        this.collectionManager = collectionManager;
        this.index = index;
        this.reader = reader;
    }

    @Override
    public void execute() {
        Flat next = reader.readFlat();
        collectionManager.getCollections().forEach(flat -> {
            if (flat.getId() == index) {
                flat.mergeWith(next);
            }
        });
    }

}
