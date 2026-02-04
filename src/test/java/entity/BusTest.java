package entity;

import entity.Bus.BusBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 25-01-2026
 * Description:
 */
class BusTest {
    private Bus bus1;
    private Bus bus2;
    private Bus bus3;
    private Bus bus4;
    private Bus bus5;
    private BusBuilder builder;

    static Stream<Arguments> busBuilderProvider() {
        return Stream.of(
                Arguments.of(new BusBuilder().setModel("Model").setMileage(100)),
                Arguments.of(new BusBuilder().setNumber(0).setModel("Model").setMileage(100)),
                Arguments.of(new BusBuilder().setNumber(-1).setModel("Model").setMileage(100)),
                Arguments.of(new BusBuilder().setNumber(1).setMileage(100)),
                Arguments.of(new BusBuilder().setNumber(1).setModel("").setMileage(0)),
                Arguments.of(new BusBuilder().setNumber(1).setModel(" ").setMileage(0)),
                Arguments.of(new BusBuilder().setNumber(1).setModel("Model").setMileage(-100))
        );
    }

    @BeforeEach
    void setUp() {
        bus1 = new BusBuilder().setNumber(1).setModel("Icarus").setMileage(100).build();
        bus2 = new BusBuilder().setNumber(2).setModel("Icarus").setMileage(100).build();
        bus3 = new BusBuilder().setNumber(1).setModel("Isuzu").setMileage(100).build();
        bus4 = new BusBuilder().setNumber(1).setModel("Icarus").setMileage(101).build();
        bus5 = new BusBuilder().setNumber(1).setModel("Icarus").setMileage(100).build();
        builder = new BusBuilder();
    }

    @RepeatedTest(1000)
    void generate() {
        Bus bus = new Bus().generate();

        assertNotNull(bus);
        assertTrue(bus.getNumber() > 0);
        assertNotNull(bus.getModel());
        assertFalse(bus.getModel().isBlank());
        assertTrue(bus.getMileage() >= 0);
    }

    @Test
    void compareTo() {
        assertTrue(bus1.compareTo(bus2) < 0);
        assertTrue(bus1.compareTo(bus3) < 0);
        assertTrue(bus1.compareTo(bus4) < 0);
        assertEquals(0, bus1.compareTo(bus5));
        assertTrue(bus2.compareTo(bus3) > 0);
        assertTrue(bus3.compareTo(bus4) > 0);
    }

    @Test
    void testToString() {
        assertEquals("number:    1 | model:                    Icarus | mileage:  100", bus1.toString());
        assertEquals("number:    2 | model:                    Icarus | mileage:  100", bus2.toString());
        assertEquals("number:    1 | model:                     Isuzu | mileage:  100", bus3.toString());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100, 1569})
    void setNumber(int number) {
        assertEquals(0, builder.getNumber());
        builder.setNumber(number);
        assertEquals(number, builder.getNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Icarus", "Mercedes", "MAZ"})
    void setModel(String model) {
        assertNull(builder.getModel());
        builder.setModel(model);
        assertEquals(model, builder.getModel());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100, 1569})
    void setMileage(int mileage) {
        assertEquals(0, builder.getMileage());
        builder.setMileage(mileage);
        assertEquals(mileage, builder.getMileage());
    }

    @Test
    void build() {
        builder.setNumber(1).setModel("Model").setMileage(100);
        Bus bus = builder.build();
        assertNotNull(bus);
        assertEquals(1, bus.getNumber());
        assertEquals("Model", bus.getModel());
        assertEquals(100, bus.getMileage());
    }

    @ParameterizedTest
    @MethodSource("busBuilderProvider")
    void build_Failure(BusBuilder wrongBusBuilder) {
        Bus bus = wrongBusBuilder.build();
        assertNull(bus);
    }
}