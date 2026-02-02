package bus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 25-01-2026
 * Description:
 */
class BusBuilderTest {
    private BusBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new BusBuilder();
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
        builder.setModel("Model").setMileage(100).setNumber(1);
        Bus bus = new Bus(builder);
        assertTrue(bus.checkBuilding());
        assertEquals(bus, builder.build());
    }

    @Test
    void build_Failure_ThrowsException() {
        builder.setNumber(0).setModel("Model").setMileage(1);
        Bus bus = new Bus(builder);
        assertFalse(bus.checkBuilding());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> builder.build());
        assertEquals("The object cannot be created", exception.getMessage());
        builder.setNumber(1).setMileage(-100);
        assertFalse(bus.checkBuilding());
        exception = assertThrows(IllegalArgumentException.class, () -> builder.build());
        assertEquals("The object cannot be created", exception.getMessage());
    }
}