package ifmo.se.cli;

import ifmo.se.cli.exc.InvalidInputException;
import ifmo.se.model.Flat;

import java.io.InputStream;

/**
 * Отвечает за чтение из файла
 */
public class FileReader extends CommandLineReader {

    public FileReader(InputStream in) {
        super(in, new MockPrintStream());
    }

    /**
     * Читает строку из файла
     * @throws InvalidInputException если произошла ошибка ввода
     * @return строка
     */
    @Override
    public Flat readFlat() {
        try {
            return tryToRead();
        } catch (Exception e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}
