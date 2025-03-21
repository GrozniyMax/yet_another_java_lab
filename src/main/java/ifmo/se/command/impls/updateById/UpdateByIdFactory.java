package ifmo.se.command.impls.updateById;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.Command;
import ifmo.se.command.CommandFactory;

public class UpdateByIdFactory implements CommandFactory {

    private final CollectionManager collectionManager;

    public UpdateByIdFactory(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }


    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new UpdateById(collectionManager, Integer.parseInt(lastText.trim()), input) ;
    }

    @Override
    public String getSupportedCommand() {
        return "update_by_id";
    }
}
