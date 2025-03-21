package ifmo.se.command.impls.add;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;

/**
 * Команда {@code add}
 */
public class Add implements Command {

    private final CollectionManager collectionManager;

    private final CommandLineReader input;

    public Add(CollectionManager collectionManager, CommandLineReader input) {
        this.collectionManager = collectionManager;
        this.input = input;
    }

    @Override
    public void execute() {
        collectionManager.add(input.readFlat());
    }
}
