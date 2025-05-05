package ifmo.se.exc;

/**
 * Исключение, возникающее при невозможности создать команду
 */
public class CommandCreationException extends RuntimeException {
    private final boolean byCause;

    public CommandCreationException(Throwable cause) {
        super(cause);
        byCause = true;
    }

    public CommandCreationException(String message) {
        super(message);
        byCause = false;
    }

    @Override
    public String getMessage() {
        if (byCause) {
            return "Не получилось распознать команду по причине: " + getCause().getMessage();
        } else {
            return super.getMessage();
        }
    }
}
