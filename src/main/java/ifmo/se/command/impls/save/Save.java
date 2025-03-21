package ifmo.se.command.impls.save;

import ifmo.se.CollectionManager;
import ifmo.se.FileReadingUtils;
import ifmo.se.command.Command;
import ifmo.se.exc.CommandExecutionException;
import ifmo.se.exc.JsonWritingException;

/**
 * Команда {@code save}
 */
public class Save implements Command {

    private final CollectionManager collectionManager;

    private final String filename;

    public Save(CollectionManager collectionManager, String filename) {
        this.collectionManager = collectionManager;
        this.filename = filename;
    }

    @Override
    public void execute() {
        try {
            FileReadingUtils.save(collectionManager, filename);
        } catch (JsonWritingException e) {
            throw new CommandExecutionException(e);
        }


    }
}
