package ifmo.se.cli.exc;

/**
 * Исключение, возникающее при некорректном вводе
 */
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }


}
