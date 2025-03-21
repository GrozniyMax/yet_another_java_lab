package ifmo.se.exc;

/**
 * Исключение, возникающее при записи в JSON
 */
public class JsonWritingException extends Exception {

    public JsonWritingException(Throwable cause) {
        super(cause);
    }

    public JsonWritingException(String message, Throwable cause) {
        super(message, cause);
    }
}

