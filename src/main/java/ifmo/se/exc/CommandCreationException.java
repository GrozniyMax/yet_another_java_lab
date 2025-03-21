package ifmo.se.exc;

/**
 * Исключение, возникающее при невозможности создать команду
 */
public class CommandCreationException extends RuntimeException {
    public CommandCreationException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return "Не получилось распознать команду по причине: " + getCause().getMessage();
    }
}
