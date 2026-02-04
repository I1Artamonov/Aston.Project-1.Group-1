package parser;

import entity.Bus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private BusParser parser;

    @BeforeEach
    void setUp() {
        parser = new BusParser();
    }

    @Test
    void parseValidBusLine() {
        String line = "12, Volvo, 150000";
        Bus bus = parser.parse(line);

        assertNotNull(bus);
        assertEquals(12, bus.getNumber());
        assertEquals("Volvo", bus.getModel());
        assertEquals(150000, bus.getMileage());
    }

    @Test
    void parseEmptyLine() {
        String line = "";

        Exception exception = assertThrows(NullPointerException.class, () -> {
            parser.parse(line);
        });


        assertNotNull(exception);
    }

    @Test
    void parseNullLine() {
        String line = null;

        Exception exception = assertThrows(NullPointerException.class, () -> {
            parser.parse(line);
        });

        assertNotNull(exception);
    }

    @Test
    void parseIncorrectNumberOfFields() {
        String line = "12, Volvo"; // только 2 поля

        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            parser.parse(line);
        });

        assertNotNull(exception);
    }

    @Test
    void parseNegativeNumber() {
        String line = "-5, Volvo, 100000";

        Bus bus = parser.parse(line);

        assertEquals(-5, bus.getNumber()); // bus создается, но выводится сообщение
        assertEquals("Volvo", bus.getModel());
        assertEquals(100000, bus.getMileage());
    }

    @Test
    void parseEmptyModel() {
        String line = "12, , 100000";

        Bus bus = parser.parse(line);

        assertEquals(12, bus.getNumber());
        assertEquals("", bus.getModel());
        assertEquals(100000, bus.getMileage());
    }

    @Test
    void parseNegativeMileage() {
        String line = "12, Volvo, -100";

        Bus bus = parser.parse(line);

        assertEquals(12, bus.getNumber());
        assertEquals("Volvo", bus.getModel());
        assertEquals(-100, bus.getMileage());
    }
}

