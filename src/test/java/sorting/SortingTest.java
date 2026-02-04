package sorting;

import customCollections.CustomList;
import entity.Bus;
import entity.Bus.BusBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 25-01-2026
 * Description:
 */
class SortingTest {
    Bus bus1;
    Bus bus2;
    Bus bus3;
    Bus bus4;
    Bus bus5;
    CustomList<Bus> startList;
    CustomList<Bus> result;


    @BeforeEach
    void setUp() {
        bus1 = new BusBuilder().setNumber(11).setModel("Mercedes Benz").setMileage(101).build();
        bus2 = new BusBuilder().setNumber(10).setModel("Icarus").setMileage(200).build();
        bus3 = new BusBuilder().setNumber(11).setModel("Isuzu").setMileage(100).build();
        bus4 = new BusBuilder().setNumber(2).setModel("Mercedes Benz").setMileage(103).build();
        bus5 = new BusBuilder().setNumber(10).setModel("Icarus").setMileage(201).build();
        startList = new CustomList<>(bus1);
        startList.add(bus2);
        startList.add(bus3);
        startList.add(bus4);
        startList.add(bus5);
        result = new CustomList<>(startList);
    }

    @Test
    void selectComparator() {
        Comparator<Bus> comparator1 = Sorting.selectComparator(1);
        assertTrue(comparator1.compare(bus1, bus2) > 0);
        assertTrue(comparator1.compare(bus1, bus3) > 0);
        assertTrue(comparator1.compare(bus1, bus4) > 0);
        Comparator<Bus> comparator2 = Sorting.selectComparator(2);
        assertTrue(comparator2.compare(bus1, bus2) > 0);
        assertTrue(comparator2.compare(bus1, bus3) > 0);
        assertTrue(comparator2.compare(bus1, bus4) > 0);
        assertTrue(comparator2.compare(bus2, bus5) < 0);
        Comparator<Bus> comparator3 = Sorting.selectComparator(3);
        assertTrue(comparator3.compare(bus1, bus2) < 0);
        assertTrue(comparator3.compare(bus1, bus3) > 0);
        assertTrue(comparator3.compare(bus1, bus4) < 0);
        assertTrue(comparator3.compare(bus2, bus5) < 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 10, 1569})
    void selectComparator_Failure_ThrowsException(int number) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Sorting.selectComparator(number));
        assertEquals("Incorrect sorting choice", exception.getMessage());
    }

    @Test
    void sortsByNumbers() {
        CustomList<Bus> expected = new CustomList<>(startList);
        expected.set(0, bus4);
        expected.set(1, bus2);
        expected.set(2, bus5);
        expected.set(3, bus3);
        expected.set(4, bus1);

        result = Sorting.sorts(startList, Sorting.selectComparator(1));

        assertNotEquals(result, startList);
        assertEquals(expected, result);
    }

    @Test
    void sortsByModels() {
        CustomList<Bus> expected = new CustomList<>(startList);
        expected.set(0, bus2);
        expected.set(1, bus5);
        expected.set(2, bus3);
        expected.set(3, bus4);
        expected.set(4, bus1);

        result = Sorting.sorts(startList, Sorting.selectComparator(2));

        assertNotEquals(result, startList);
        assertEquals(expected, result);
    }

    @Test
    void sortsByMileages() {
        CustomList<Bus> expected = new CustomList<>(startList);
        expected.set(0, bus3);
        expected.set(1, bus1);
        expected.set(2, bus4);
        expected.set(3, bus2);
        expected.set(4, bus5);

        result = Sorting.sorts(startList, Sorting.selectComparator(3));

        assertNotEquals(result, startList);
        assertEquals(expected, result);
    }

    @Test
    void sortEvenKeepOdd() {
        CustomList<Bus> expected = new CustomList<>(startList);
        expected.set(0, bus1);
        expected.set(1, bus4);
        expected.set(2, bus3);
        expected.set(3, bus2);
        expected.set(4, bus5);

        result = Sorting.sortEvenKeepOdd(startList);

        assertEquals(expected, result);
    }
}