package ifmo.se.exc;

/**
 * Исключение, возникающее при выполнении команды
 */
public class CommandExecutionException extends RuntimeException {
    public CommandExecutionException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "Произошла ошибка: " + getCause().getMessage();
    }
}
