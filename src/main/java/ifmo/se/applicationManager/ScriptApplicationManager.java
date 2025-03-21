package ifmo.se.applicationManager;

import ifmo.se.cli.exc.EofException;
import ifmo.se.command.AbstractCommandFactory;
import ifmo.se.command.Command;
import ifmo.se.command.CommandExecutor;
import ifmo.se.exc.CommandCreationException;
import ifmo.se.exc.CommandExecutionException;
import ifmo.se.exc.ExitCommandException;

import java.io.PrintStream;

/**
 * Класс, управляющий исполнением скрипта
 */
public class ScriptApplicationManager extends ApplicationManager {
    public ScriptApplicationManager(AbstractCommandFactory commandFactory, CommandExecutor commandExecutor, PrintStream out) {
        super(commandFactory, commandExecutor, out);
    }

    public void run() {
        while (true) {
            try {
                Command command = commandFactory.createCommand();
                commandExecutor.execute(command);
            } catch (ExitCommandException | EofException e) {
                break;
            } catch (CommandExecutionException | CommandCreationException e) {
                out.println(e.getMessage());
            }
        }

    }
}
