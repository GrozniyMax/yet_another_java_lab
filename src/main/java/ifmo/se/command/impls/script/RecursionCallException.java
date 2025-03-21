package ifmo.se.command.impls.script;

/**
 * Исключение, возникающее при рекурсивном вызове скрипта
 */
public class RecursionCallException extends ScriptExecutionException {


    @Override
    public String getMessage() {
        return "Ошибка в исполнении скрипта: Рекурсивный вызов";
    }
}
