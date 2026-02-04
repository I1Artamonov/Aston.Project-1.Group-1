package writer;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextFileWriterTest {

    private static final Path FILE = Path.of("src", "main", "resources", "output.txt");

    private TextFileWriter<String> writer;

    @BeforeEach
    void setUp() throws IOException {
        writer = new TextFileWriter<>();
        Files.createDirectories(FILE.getParent());
        Files.deleteIfExists(FILE);
    }

    @AfterEach
    void tearDown() throws IOException {

        if (Files.exists(FILE)) {
            if (Files.isDirectory(FILE)) {
                Files.delete(FILE);
            } else {
                Files.delete(FILE);
            }
        }
    }

    @Test
    void write_null_doesNothingAndDoesNotCreateFile() {
        writer.write(null);
        assertFalse(Files.exists(FILE), "Файл не должен быть создан при записи null");
    }

    @Test
    void write_appendsSingleLine() throws IOException {
        writer.write("abc");

        assertTrue(Files.exists(FILE));
        assertEquals(List.of("abc"), Files.readAllLines(FILE));
    }

    @Test
    void write_appendsMultipleCalls() throws IOException {
        writer.write("abc");
        writer.write("def");

        assertEquals(List.of("abc", "def"), Files.readAllLines(FILE));
    }

    @Test
    void writeCollection_null_doesNothingAndDoesNotCreateFile() {
        writer.writeCollection(null);
        assertFalse(Files.exists(FILE), "Файл не должен быть создан при записи null-коллекции");
    }

    @Test
    void writeCollection_writesAllNonNullValues() throws IOException {

        writer.writeCollection(Arrays.asList("a", null, "b", "c"));

        assertTrue(Files.exists(FILE));
        assertEquals(List.of("a", "b", "c"), Files.readAllLines(FILE));
    }

    @Test
    void write_ignoresIOException_whenPathIsDirectory() throws IOException {

        Files.createDirectories(FILE.getParent());
        Files.createDirectory(FILE);

        assertDoesNotThrow(() -> writer.write("abc"));

        assertTrue(Files.isDirectory(FILE));
    }

    @Test
    void writeCollection_ignoresIOException_whenPathIsDirectory() throws IOException {
        Files.createDirectories(FILE.getParent());
        Files.createDirectory(FILE);

        assertDoesNotThrow(() -> writer.writeCollection(List.of("a", "b")));
        assertTrue(Files.isDirectory(FILE));
    }
}
