package ifmo.se.command.impls.show;

import ifmo.se.CollectionManager;
import ifmo.se.command.Command;

import java.io.PrintStream;

/**
 * Команда {@code show}
 */
public class Show implements Command {

    private final CollectionManager collectionManager;

    private final PrintStream out;

    public Show(CollectionManager collectionManager, PrintStream out) {
        this.collectionManager = collectionManager;
        this.out = out;
    }


    @Override
    public void execute() {
        if (collectionManager.getSize() == 0) {
            out.println("Коллекция пустая");
            return;
        }
        out.println("Ваша коллекция:");
        collectionManager.getCollections().forEach(out::println);
    }
}
