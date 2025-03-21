package ifmo.se.command.impls.script;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.AbstractCommandFactory;
import ifmo.se.command.Command;
import ifmo.se.command.CommandExecutor;
import ifmo.se.command.CommandFactory;

import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Фабрика команды {@code execute_script}
 */
public class ExecuteScriptFactory implements CommandFactory {

    private static final Set<Path> usedFiles = new HashSet<>();

    private final AbstractCommandFactory commandFactory;

    private final CommandExecutor commandExecutor;

    private final PrintStream out;

    public ExecuteScriptFactory(AbstractCommandFactory commandFactory, CommandExecutor commandExecutor, PrintStream out) {
        this.commandFactory = commandFactory;
        this.commandExecutor = commandExecutor;
        this.out = out;
    }


    @Override
    public Command create(CommandLineReader input, String lastText) {
        return new ExecuteScript( commandFactory, commandExecutor, Paths.get(lastText), usedFiles, out );
    }

    @Override
    public String getSupportedCommand() {
        return "execute_script";
    }
}
