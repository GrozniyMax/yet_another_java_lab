package ifmo.se.cli.exc;

/**
 * Исключение, возникающее при достижении конца файла(Потока ввода)
 */
public class EofException extends RuntimeException {
    public EofException() {
        super();
    }
}
