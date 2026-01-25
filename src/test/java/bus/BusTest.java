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
        bus1 = new BusBuilder().setModel("Icarus").setMileage(100).setNumber(1).build();
        bus2 = new BusBuilder().setModel("Mercedes Benz").setMileage(5430).setNumber(598).build();
        bus3 = new BusBuilder().setModel("Isuzu").setMileage(243).setNumber(186).build();
    }

    @Test
    void checkBuilding() {
        BusBuilder busBuilder1 = new BusBuilder().setModel("Model").setMileage(100).setNumber(1);
        BusBuilder busBuilder2 = new BusBuilder().setMileage(100).setNumber(1);
        BusBuilder busBuilder3 = new BusBuilder().setModel("").setMileage(0).setNumber(1);
        BusBuilder busBuilder4 = new BusBuilder().setModel("Model").setNumber(1);
        BusBuilder busBuilder5 = new BusBuilder().setModel("Model").setMileage(-100).setNumber(1);
        BusBuilder busBuilder6 = new BusBuilder().setModel("Model").setMileage(100);
        BusBuilder busBuilder7 = new BusBuilder().setModel("Model").setMileage(100).setNumber(-1);
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
        Bus bus = new Bus().generate();
        assertNotNull(bus);
        assertNotNull(bus.getModel());
        assertFalse(bus.getModel().isBlank());
        assertTrue(bus.getMileage() >= 0);
        assertTrue(bus.getNumber() > 0);
    }

    @Test
    void compareTo() {
        assertTrue(bus1.compareTo(bus2) < 0);
        Bus bus4 = new BusBuilder().setModel("Icarus").setMileage(99).setNumber(1).build();
        assertTrue(bus1.compareTo(bus4) > 0);
        Bus bus5 = new BusBuilder().setModel("Icarus").setMileage(100).setNumber(2).build();
        assertTrue(bus1.compareTo(bus5) < 0);
        Bus bus6 = new BusBuilder().setModel("Icarus").setMileage(100).setNumber(1).build();
        assertEquals(0, bus1.compareTo(bus6));
    }

    @Test
    void testToString() {
        assertEquals("model:                    Icarus | mileage:  100 | number:    1", bus1.toString());
        assertEquals("model:             Mercedes Benz | mileage: 5430 | number:  598", bus2.toString());
        assertEquals("model:                     Isuzu | mileage:  243 | number:  186", bus3.toString());
    }
}