package ifmo.se.applicationManager;

import ifmo.se.cli.exc.EofException;
import ifmo.se.command.AbstractCommandFactory;
import ifmo.se.command.Command;
import ifmo.se.command.CommandExecutor;
import ifmo.se.command.impls.script.ScriptExecutionException;
import ifmo.se.exc.CommandCreationException;
import ifmo.se.exc.CommandExecutionException;
import ifmo.se.exc.ExitCommandException;

import java.io.PrintStream;

/**
 * Класс, управляющий приложением
 */
public class ApplicationManager {

    protected final AbstractCommandFactory commandFactory;

    protected final CommandExecutor commandExecutor;

    protected final PrintStream out;

    public ApplicationManager(AbstractCommandFactory commandFactory, CommandExecutor commandExecutor, PrintStream out) {
        this.commandFactory = commandFactory;
        this.commandExecutor = commandExecutor;
        this.out = out;
    }


    /**
     * Запускает приложение
     */
    public void run() {
        while (true) {
            try {
                Command command = commandFactory.createCommand();
                commandExecutor.execute(command);
            } catch (ExitCommandException | EofException e) {
                break;
            } catch (CommandExecutionException | CommandCreationException | ScriptExecutionException e) {
                out.println(e.getMessage());
            }
        }

    }

}
