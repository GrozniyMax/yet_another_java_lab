package ifmo.se.command.impls.save;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

import java.nio.file.Path;

/**
 * Фабрика команды {@code save}
 */
public class SaveFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    private final Path file;

    public SaveFactory(CollectionManager collectionManager, Path file) {
        this.collectionManager = collectionManager;
        this.file = file;
    }

    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new Save(collectionManager, file.toString());
    }

    @Override
    public String getSupportedCommand() {
        return "save";
    }
}
