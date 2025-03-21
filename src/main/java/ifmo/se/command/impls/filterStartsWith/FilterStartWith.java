package ifmo.se.command.impls.filterStartsWith;

import ifmo.se.CollectionManager;
import ifmo.se.command.Command;
import ifmo.se.model.Flat;

import java.io.PrintStream;

/**
 * Команда {@code filter_starts_with}
 */
public class FilterStartWith implements Command {

    private final CollectionManager collectionManager;

    private final String name;

    private final PrintStream out;

    public FilterStartWith(CollectionManager collectionManager, String name, PrintStream out) {
        this.collectionManager = collectionManager;
        this.name = name;
        this.out = out;
    }

    @Override
    public void execute() {
        for (Flat f : collectionManager.getCollections()) {
            if (f.getName().startsWith(name)) {
                out.println(f);
            }

        }

    }
}
