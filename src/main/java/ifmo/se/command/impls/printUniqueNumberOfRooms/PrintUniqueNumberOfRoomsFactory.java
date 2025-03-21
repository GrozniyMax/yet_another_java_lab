package ifmo.se.command.impls.printUniqueNumberOfRooms;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

import java.io.PrintStream;

/**
 * Фабрика команды {@code print_unique_number_of_rooms}
 */
public class PrintUniqueNumberOfRoomsFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    private final PrintStream out;

    public PrintUniqueNumberOfRoomsFactory(CollectionManager collectionManager, PrintStream out) {
        this.collectionManager = collectionManager;
        this.out = out;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new PrintUniqueNumberOfRooms(collectionManager, out);
    }

    @Override
    public String getSupportedCommand() {
        return "print_unique_number_of_rooms";
    }
}
