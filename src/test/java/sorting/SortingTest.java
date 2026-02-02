package sorting;

import bus.Bus;
import bus.BusBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    List<Bus> startList;
    List<Bus> result;


    @BeforeEach
    void setUp() {
        bus1 = new BusBuilder().setNumber(11).setModel("Mercedes Benz").setMileage(101).build();
        bus2 = new BusBuilder().setNumber(10).setModel("Icarus").setMileage(200).build();
        bus3 = new BusBuilder().setNumber(11).setModel("Isuzu").setMileage(100).build();
        bus4 = new BusBuilder().setNumber(11).setModel("Mercedes Benz").setMileage(103).build();
        bus5 = new BusBuilder().setNumber(1).setModel("Icarus").setMileage(102).build();
        List<Bus> start = List.of(bus1, bus2, bus3, bus4, bus5);
        startList = new ArrayList<>(start);
        result = new ArrayList<>();
    }

    @Test
    void selectComparator() {
        Comparator<Bus> comparator1 = Sorting.selectComparator(1);
        assertTrue(comparator1.compare(bus1, bus2) > 0);
        Comparator<Bus> comparator2 = Sorting.selectComparator(2);
        assertTrue(comparator2.compare(bus3, bus1) < 0);
        Comparator<Bus> comparator3 = Sorting.selectComparator(3);
        assertTrue(comparator3.compare(bus1, bus4) < 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 10, 1569})
    void selectComparator_Failure_ThrowsException(int number) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Sorting.selectComparator(number));
        assertEquals("Incorrect sorting choice", exception.getMessage());
    }


    @Test
    void selectionSort() {
        result = Sorting.selectionSort(startList, Sorting.selectComparator(1));
        List<Bus> expected1 = List.of(bus5, bus2, bus3, bus1, bus4);
        System.out.println(startList);
        System.out.println(result);
        assertNotEquals(result, startList);
        assertNotEquals(expected1, startList);
        assertEquals(expected1, result);
        result = Sorting.selectionSort(result, Sorting.selectComparator(2));
        List<Bus> expected2 = List.of(bus3, bus1, bus5, bus4, bus2);
        //assertEquals(expected2, result);
        result = Sorting.selectionSort(result, Sorting.selectComparator(3));
        List<Bus> expected3 = List.of(bus3, bus4, bus2, bus1, bus5);
        //assertEquals(expected3, result);
    }

    @Test
    void sortEvenKeepOdd() {
        /*result = Sorting.sortEvenKeepOdd(result);
        List<Bus> expected1 = List.of(bus1, bus5, bus3, bus4, bus2);
        assertEquals(expected1, result);*/
    }
}