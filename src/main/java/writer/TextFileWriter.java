package writer; 

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TextFileWriter<T> implements ResultWriter<T> {

    private static final Path FILE = Path.of("src", "main", "resources", "output.txt");

    @Override
    public void write(T obj) {
        if (obj == null) {
            return;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(
                FILE,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {
            writer.write(obj.toString());
            writer.newLine();
        } catch (IOException ignored) {

        }
    }

    @Override
    public void writeCollection(Iterable<? extends T> values) {
        if (values == null) {
            return;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(
                FILE,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {

            for (T value : values) {
                if (value == null) continue;
                writer.write(value.toString());
                writer.newLine();
            }
        } catch (IOException ignored) {

        }
    }
}
