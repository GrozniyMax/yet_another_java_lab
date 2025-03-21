package ifmo.se.command;

import ifmo.se.CollectionManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.impls.add.AddFactory;
import ifmo.se.command.impls.addIfMin.AddIfMinFactory;
import ifmo.se.command.impls.clear.ClearFactory;
import ifmo.se.command.impls.exit.ExitCommandFactory;
import ifmo.se.command.impls.filterStartsWith.FilterStartsWithFactory;
import ifmo.se.command.impls.help.HelpFactory;
import ifmo.se.command.impls.info.InfoFactory;
import ifmo.se.command.impls.printFieldDescendingView.PrintFieldDescendingViewFactory;
import ifmo.se.command.impls.printUniqueNumberOfRooms.PrintUniqueNumberOfRoomsFactory;
import ifmo.se.command.impls.removeById.RemoveByIdFactory;
import ifmo.se.command.impls.removeFirst.RemoveFirstFactory;
import ifmo.se.command.impls.removeGreater.RemoveGreaterFactory;
import ifmo.se.command.impls.save.Save;
import ifmo.se.command.impls.save.SaveFactory;
import ifmo.se.command.impls.script.ExecuteScriptFactory;
import ifmo.se.command.impls.show.ShowFactory;
import ifmo.se.command.impls.updateById.UpdateByIdFactory;
import ifmo.se.exc.CommandCreationException;
import ifmo.se.exc.CommandExecutionException;

import java.io.PrintStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактная фабрика команд
 */
public class AbstractCommandFactory {

    /**
     * Список фабрик команд
     */
    private Map<String, CommandFactory> factories = new HashMap<>();

    private final PrintStream out;

    private final CommandLineReader input;

    private final CollectionManager collectionManager;

    private final CommandExecutor commandExecutor;

    private final Path file;


    public AbstractCommandFactory(PrintStream out, CommandLineReader input, CollectionManager collectionManager,
                                  CommandExecutor commandExecutor, Path file) {
        this.out = out;
        this.input = input;
        this.collectionManager = collectionManager;
        this.commandExecutor = commandExecutor;
        this.file = file;
        fillFactories();
    }

    public AbstractCommandFactory(AbstractCommandFactory commandFactory, CommandLineReader input) {
        this.input = input;
        this.out = commandFactory.out;
        this.collectionManager = commandFactory.collectionManager;
        this.factories = commandFactory.factories;
        this.commandExecutor = commandFactory.commandExecutor;
        this.file = commandFactory.file;
    }

    /**
     * Заполнение списка фабрик команд
     */
    private void fillFactories() {
        factories.put("help", new HelpFactory(out));
        factories.put("info", new InfoFactory(collectionManager, out));
        factories.put("show", new ShowFactory(collectionManager, out));
        factories.put("add", new AddFactory(collectionManager));
        factories.put("update", new UpdateByIdFactory(collectionManager));
        factories.put("remove_by_id", new RemoveByIdFactory(collectionManager));
        factories.put("clear", new ClearFactory(collectionManager));
        factories.put("save", new SaveFactory(collectionManager, file));
        factories.put("execute_script", new ExecuteScriptFactory(this, commandExecutor, out));
        factories.put("exit", new ExitCommandFactory());
        factories.put("remove_first", new RemoveFirstFactory(collectionManager));
        factories.put("add_if_min", new AddIfMinFactory(collectionManager));
        factories.put("remove_greater", new RemoveGreaterFactory(collectionManager));
        factories.put("filter_starts_with_name", new FilterStartsWithFactory(collectionManager, out));
        factories.put("print_unique_number_of_rooms", new PrintUniqueNumberOfRoomsFactory(collectionManager, out));
        factories.put("print_field_descending_view", new PrintFieldDescendingViewFactory(collectionManager, out));
    }


    /**
     * Создание команды
     *
     * @param line строка с командой
     * @return команда
     */
    private Command createCommand(String line) {
        try {
            String[] parts = line.split(" ");
            String command = parts[0];
            String lineArg = parts.length < 2 ? null : parts[1];
            CommandFactory factory = factories.get(command);
            return factory.create(input, lineArg);
        } catch (RuntimeException e) {
            throw new CommandCreationException(e);
        }
    }


    /**
     * Создание команды
     *
     * @return команда
     */
    public Command createCommand() {
        String line = input.readLine();
        return createCommand(line);
    }


}
