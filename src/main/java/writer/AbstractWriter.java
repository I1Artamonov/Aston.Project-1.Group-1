package writer;

import java.io.IOException;
import java.util.Objects;

public abstract class AbstractWriter<T> implements ResultWriter<T> {

    private final Formatter<T> formatter;

    protected AbstractWriter(Formatter<T> formatter) {
        this.formatter = Objects.requireNonNull(formatter);
    }

    @Override
    public final void write(Iterable<T> data) throws IOException {
        Objects.requireNonNull(data, "data must not be null");
        beforeWrite();
        try {
            for (T item : data) {
                writeLine(formatter.format(item));
            }
            afterWrite();
        } finally {
            close();
        }
    }

    protected void beforeWrite() throws IOException { }

    protected void afterWrite() throws IOException { }

    protected abstract void writeLine(String line) throws IOException;

    protected void close() throws IOException { }
}
