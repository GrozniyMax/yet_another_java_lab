package ifmo.se;

import ifmo.se.applicationManager.ApplicationManager;
import ifmo.se.cli.CommandLineReader;
import ifmo.se.command.AbstractCommandFactory;
import ifmo.se.command.CommandExecutor;
import ifmo.se.exc.JsonWritingException;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


public class Main {

    private static final String GREET_MESSAGE = "Привет!";
    private static final String INVALID_CLI_ARGS = "";//todo заполнить
    private static final String FILE_NOT_FOUND = "File not found!";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(INVALID_CLI_ARGS);
            return;
        }
        Path collectionFile;
        CollectionManager collectionManager;
        try {
            collectionFile = Paths.get(args[0]);
            collectionManager = FileReadingUtils.load(collectionFile);
            collectionManager = Objects.isNull(collectionManager) ? new CollectionManager() : collectionManager;
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        CollectionManager finalCollectionManager = collectionManager;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                FileReadingUtils.save(finalCollectionManager, collectionFile.toString());
            } catch (JsonWritingException e) {
                System.out.println("Коллекция не сохранена");
            }
        }));

        CommandLineReader commandLineReader = new CommandLineReader(System.in, System.out);

        CommandExecutor commandExecutor = new CommandExecutor();
        AbstractCommandFactory commandFactory = new AbstractCommandFactory(System.out, commandLineReader,
                collectionManager, commandExecutor, collectionFile);
        ApplicationManager applicationManager = new ApplicationManager(commandFactory, commandExecutor, System.out);


        System.out.println(GREET_MESSAGE);

        applicationManager.run();
    }


}
