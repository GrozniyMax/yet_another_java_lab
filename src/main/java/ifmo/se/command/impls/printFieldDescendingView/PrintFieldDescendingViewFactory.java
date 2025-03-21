package ifmo.se.command.impls.printFieldDescendingView;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;
import ifmo.se.command.impls.printUniqueNumberOfRooms.PrintUniqueNumberOfRooms;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Фабрика команды {@code print_field_descending_view}
 */
public class PrintFieldDescendingViewFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    private final PrintStream out;

    public PrintFieldDescendingViewFactory(CollectionManager collectionManager, PrintStream out) {
        this.collectionManager = collectionManager;
        this.out = out;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new PrintFieldDescendingView(collectionManager, out);
    }

    @Override
    public String getSupportedCommand() {
        return "print_field_descending_view";
    }
}
