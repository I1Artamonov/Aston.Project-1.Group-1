//package writer;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class ConsoleWriterTest {
//
//    private final PrintStream originalOut = System.out;
//    private ByteArrayOutputStream buffer;
//
//    @BeforeEach
//    void setUp() {
//        buffer = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(buffer));
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.setOut(originalOut);
//    }
//
//    @Test
//    void write_whenNull_printsNothing() {
//        ConsoleWriterTest<String> writer = new ConsoleWriterTest<>();
//        writer.write(null);
//
//        assertEquals("", buffer.toString());
//    }
//
//    @Test
//    void write_printsObjectToString() {
//        ConsoleWriterTest<String> writer = new ConsoleWriterTest<>();
//        writer.write("hello");
//
//        assertEquals("hello" + System.lineSeparator(), buffer.toString());
//    }
//
//    @Test
//    void writeCollection_printsEachElement() {
//        ConsoleWriterTest<String> writer = new ConsoleWriterTest<>();
//        writer.writeCollection(List.of("a", "b"));
//
//        String expected = "a" + System.lineSeparator() + "b" + System.lineSeparator();
//        assertEquals(expected, buffer.toString());
//    }
//}
