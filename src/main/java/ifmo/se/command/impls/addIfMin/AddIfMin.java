package ifmo.se.command.impls.addIfMin;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.model.Flat;

/**
 * Команда {@code add_if_min}
 */
public class AddIfMin implements Command {

    private final CollectionManager collectionManager;

    private final CommandLineReader input;

    public AddIfMin(CollectionManager collectionManager, CommandLineReader input) {
        this.collectionManager = collectionManager;
        this.input = input;
    }


    @Override
    public void execute() {
        Flat newFlat = input.readFlat();

        for (Flat f: collectionManager.getCollections()) {
            if (f.compareTo(newFlat) < 0) {
                return;
            }
        }

        collectionManager.add(newFlat);
    }
}
