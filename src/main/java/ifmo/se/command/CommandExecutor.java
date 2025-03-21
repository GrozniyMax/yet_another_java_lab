package ifmo.se.command;

import ifmo.se.cli.exc.EofException;
import ifmo.se.cli.exc.InvalidInputException;
import ifmo.se.command.impls.script.ScriptExecutionException;
import ifmo.se.exc.CommandExecutionException;
import ifmo.se.exc.ExitCommandException;

/**
 * Класс, выполняющий команды
 */
public class CommandExecutor {


    /**
     * Выполнение команды
     * @param command команда
     * @throws EofException если при попытке чтения дополнительных данных достигнут конец ввода
     * @throws ExitCommandException если вызвана команда {@link ifmo.se.command.impls.exit.Exit}
     * @throws ScriptExecutionException если произошла ошибка {@link InvalidInputException}
     * @throws CommandExecutionException если произошла ошибка при выполнении команды
     */
    public void execute(Command command) {
        try {
            command.execute();
        } catch (EofException | ExitCommandException | ScriptExecutionException e) {
            throw e;
        } catch (InvalidInputException e){
            throw new ScriptExecutionException(e);
        } catch (Exception e) {
            throw new CommandExecutionException(e);
        }

    }
}
