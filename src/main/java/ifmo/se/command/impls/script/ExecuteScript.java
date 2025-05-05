package ifmo.se.command.impls.script;

import ifmo.se.applicationManager.ScriptApplicationManager;
import ifmo.se.cli.FileReader;
import ifmo.se.cli.exc.InvalidInputException;
import ifmo.se.command.AbstractCommandFactory;
import ifmo.se.command.Command;
import ifmo.se.command.CommandExecutor;
import ifmo.se.exc.CommandCreationException;
import ifmo.se.exc.CommandExecutionException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.Set;

/**
 * Команда {@code execute_script}
 */
public class ExecuteScript implements Command {

    private final Path file;

    private final Set<Path> usedFiles;

    private final AbstractCommandFactory commandFactory;

    private final CommandExecutor commandExecutor;

    private final PrintStream out;

    public ExecuteScript(AbstractCommandFactory commandFactory, CommandExecutor commandExecutor,
                         Path file, Set<Path> usedFiles, PrintStream out) {
        this.commandFactory = commandFactory;
        this.commandExecutor = commandExecutor;
        this.file = file;
        this.usedFiles = usedFiles;
        this.out = out;
    }

    @Override
    public void execute() {
        if (usedFiles.contains(file.toAbsolutePath())) {
            throw new RecursionCallException();
        }
        try {
            var reader = new FileReader(new FileInputStream(file.toFile()));
            usedFiles.add(file.toAbsolutePath());
            new ScriptApplicationManager(new AbstractCommandFactory(commandFactory, reader), commandExecutor, out).run();
        } catch (FileNotFoundException e) {
            throw new CommandExecutionException(e);
        } catch (CommandExecutionException e) {
            throw e;
        } catch (InvalidInputException | CommandCreationException e) {
            throw new ScriptExecutionException(e);
        } finally {
            usedFiles.remove(file.toAbsolutePath());
        }


    }
}
