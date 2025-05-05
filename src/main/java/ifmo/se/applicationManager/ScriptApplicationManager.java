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
        boolean succecced = true;
        while (true) {
            try {
                Command command = commandFactory.createCommand();
                commandExecutor.execute(command);
            } catch (ExitCommandException | EofException e) {
                break;
            } catch (Exception e) {
                out.println(e.getMessage());
                succecced = false;
            }
        }
        if (succecced) {
            out.println("Скрипт выполнен успешно");
        } else {
            out.println("Скрипт выполнен с ошибками");
        }
    }

}
