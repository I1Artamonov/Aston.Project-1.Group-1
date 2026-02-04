package reader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleReaderTest {

    private InputStream originalSystemIn = System.in;

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalSystemIn);
    }

    @Test
    void consoleReader_read_returnsEnteredLines() {
        String input = "hello\nworld\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConsoleReader reader = new ConsoleReader();
        String[] result = reader.read(2);

        assertEquals(2, result.length);
        assertEquals("hello", result[0]);
        assertEquals("world", result[1]);
    }

    @Test
    void consoleReader_readCount_returnsNumber() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConsoleReader reader = new ConsoleReader();
        int count = reader.readCount();

        assertEquals(5, count);
    }
}
