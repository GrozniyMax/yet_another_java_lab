package ifmo.se.command.impls.exit;

import ifmo.se.command.Command;
import ifmo.se.exc.ExitCommandException;

/**
 * Команда {@code exit}
 */
public class Exit implements Command {
    @Override
    public void execute() {
        throw new ExitCommandException();
    }
}
