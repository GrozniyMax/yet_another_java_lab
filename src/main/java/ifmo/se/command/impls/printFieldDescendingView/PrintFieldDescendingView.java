package ifmo.se.command.impls.printFieldDescendingView;

import ifmo.se.CollectionManager;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;
import ifmo.se.model.View;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Фабрика команды {@code print_field_descending_view}
 */
public class PrintFieldDescendingView implements Command {

    private final CollectionManager collectionManager;

    private final PrintStream out;

    public PrintFieldDescendingView(CollectionManager collectionManager, PrintStream out) {
        this.collectionManager = collectionManager;
        this.out = out;
    }

    @Override
    public void execute() {
        List<View> views = new ArrayList<>(collectionManager.getSize());

        collectionManager.getCollections().forEach(f -> views.add(f.getView()));

        views.sort(Comparator.naturalOrder());
        views.forEach(out::println);
    }
}
