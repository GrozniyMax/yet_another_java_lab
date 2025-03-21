package ifmo.se.command.impls.printUniqueNumberOfRooms;

import ifmo.se.CollectionManager;
import ifmo.se.command.Command;
import ifmo.se.model.Flat;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Команда {@code print_unique_number_of_rooms}
 */
public class PrintUniqueNumberOfRooms implements Command {

    private final CollectionManager collectionManager;

    private final PrintStream out;

    public PrintUniqueNumberOfRooms(CollectionManager collectionManager, PrintStream out) {
        this.collectionManager = collectionManager;
        this.out = out;
    }


    @Override
    public void execute() {
        Set<Long> uniques = new HashSet<>();

        for (Flat flat : collectionManager.getCollections()) {
            uniques.add(flat.getNumberOfRooms());
        }

        out.println(uniques);
    }
}
