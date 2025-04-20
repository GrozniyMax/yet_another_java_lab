package ifmo.se.command.impls.add;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;

import java.io.PrintStream;

/**
 * Команда {@code add}
 */
public class Add implements Command {

    private final CollectionManager collectionManager;

    private final CommandLineReader input;

    private final PrintStream out;

    public Add(CollectionManager collectionManager, CommandLineReader input, PrintStream out) {
        this.collectionManager = collectionManager;
        this.input = input;
        this.out = out;
    }

    @Override
    public void execute() {
        collectionManager.add(input.readFlat());
        out.println("Элемент добавлен");
    }
}
