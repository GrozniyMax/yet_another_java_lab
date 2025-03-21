package ifmo.se.cli;

import java.io.*;

/**
 * Заглушка для {@link PrintStream}
 * Данный поток не выполняет никаких записей
 * @see PrintStream
 */
public class MockPrintStream extends PrintStream {


    public MockPrintStream() {
        super(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        });
    }
}
