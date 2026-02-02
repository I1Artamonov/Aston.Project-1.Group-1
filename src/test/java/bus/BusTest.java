package bus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 25-01-2026
 * Description: 
 */class BusTest {
    Bus bus1;
    Bus bus2;
    Bus bus3;

    @BeforeEach
    void setUp() {
        bus1 = new BusBuilder().setNumber(1).setModel("Icarus").setMileage(100).build();
        bus2 = new BusBuilder().setNumber(598).setModel("Mercedes Benz").setMileage(5430).build();
        bus3 = new BusBuilder().setNumber(186).setModel("Isuzu").setMileage(243).build();
    }

    @Test
    void checkBuilding() {
        BusBuilder busBuilder1 = new BusBuilder().setNumber(1).setModel("Model").setMileage(100);
        BusBuilder busBuilder2 = new BusBuilder().setNumber(1).setMileage(100);
        BusBuilder busBuilder3 = new BusBuilder().setNumber(1).setModel("").setMileage(0);
        BusBuilder busBuilder4 = new BusBuilder().setNumber(1).setModel("Model");
        BusBuilder busBuilder5 = new BusBuilder().setNumber(1).setModel("Model").setMileage(-100);
        BusBuilder busBuilder6 = new BusBuilder().setModel("Model").setMileage(100);
        BusBuilder busBuilder7 = new BusBuilder().setNumber(-1).setModel("Model").setMileage(100);
        assertTrue(new Bus(busBuilder1).checkBuilding());
        assertFalse(new Bus(busBuilder2).checkBuilding());
        assertFalse(new Bus(busBuilder3).checkBuilding());
        assertTrue(new Bus(busBuilder4).checkBuilding());
        assertFalse(new Bus(busBuilder5).checkBuilding());
        assertFalse(new Bus(busBuilder6).checkBuilding());
        assertFalse(new Bus(busBuilder7).checkBuilding());
    }

    @RepeatedTest(1000)
    void generate() {
        Bus bus = new Bus(new BusBuilder()).generate();
        assertNotNull(bus);
        assertNotNull(bus.getModel());
        assertFalse(bus.getModel().isBlank());
        assertTrue(bus.getMileage() >= 0);
        assertTrue(bus.getNumber() > 0);
    }

    @Test
    void compareTo() {
        assertTrue(bus1.compareTo(bus2) < 0);
        Bus bus4 = new BusBuilder().setNumber(1).setModel("Icarus").setMileage(99).build();
        assertTrue(bus1.compareTo(bus4) > 0);
        Bus bus5 = new BusBuilder().setNumber(2).setModel("Icarus").setMileage(100).build();
        assertTrue(bus1.compareTo(bus5) < 0);
        Bus bus6 = new BusBuilder().setNumber(1).setModel("Icarus").setMileage(100).build();
        assertEquals(0, bus1.compareTo(bus6));
    }

    @Test
    void testToString() {
        assertEquals("number:    1 | model:                    Icarus | mileage:  100", bus1.toString());
        assertEquals("number:  598 | model:             Mercedes Benz | mileage: 5430", bus2.toString());
        assertEquals("number:  186 | model:                     Isuzu | mileage:  243", bus3.toString());
    }
}