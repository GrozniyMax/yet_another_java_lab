package ifmo.se.command.impls.info;

import ifmo.se.CollectionManager;
import ifmo.se.command.Command;

import java.io.PrintStream;

/**
 * Команда {@code info}
 */
public class Info implements Command {


    private static final String msg = """
            Тип коллекции - Flat
            Дата инициализации - %s
            Количество элементов - %d
            Последний использованный id %d
            """;

    private final CollectionManager collectionManager;

    private final PrintStream out;

    public Info(CollectionManager collectionManager, PrintStream out) {
        this.collectionManager = collectionManager;
        this.out = out;
    }


    @Override
    public void execute() {
        out.printf(msg, collectionManager.getInitDate(), collectionManager.getSize(), collectionManager.getLastId());
    }
}
