package ifmo.se.exc;

/**
 * Исключение для выхода из программы
 * @see ifmo.se.command.impls.exit.Exit
 */
public class ExitCommandException extends RuntimeException {
    public ExitCommandException(String message) {
        super(message);
    }

    public ExitCommandException() {
        super();
    }
}
