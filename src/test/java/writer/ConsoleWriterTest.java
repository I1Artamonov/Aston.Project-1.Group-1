package writer;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleWriterTest {

    private ConsoleWriter<String> writer;

    private PrintStream originalOut;
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
        writer = new ConsoleWriter<>();

        originalOut = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    private String output() {
        return out.toString(StandardCharsets.UTF_8);
    }

    @Test
    void write_null_printsNothing() {
        writer.write(null);
        assertEquals("", output());
    }

    @Test
    void write_printsSingleLine() {
        writer.write("hello");
        assertEquals("hello" + System.lineSeparator(), output());
    }

    @Test
    void writeCollection_null_printsNothing() {
        writer.writeCollection(null);
        assertEquals("", output());
    }

    @Test
    void writeCollection_printsEachOnNewLine() {
        writer.writeCollection(List.of("a", "b", "c"));

        String expected =
                "a" + System.lineSeparator() +
                        "b" + System.lineSeparator() +
                        "c" + System.lineSeparator();

        assertEquals(expected, output());
    }

    @Test
    void writeCollection_containsNull_throwsNpe() {
        assertThrows(NullPointerException.class,
                () -> writer.writeCollection(List.of("a", null, "b")));
    }
}
