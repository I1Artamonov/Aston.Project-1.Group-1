package entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 25-01-2026
 * Description:
 */
class GeneratedTest {

    @Test
    void generateFromList() {
        /*String[] strings = {"A", "B", "C", "D"};
        Integer[] ints = {1, 2, 3};
        Bus bus1 = new Bus(new BusBuilder().setModel("Model").setMileage(1).setNumber(1));
        Bus bus2 = new Bus(new BusBuilder().setModel("AnotherModel").setMileage(10).setNumber(10));
        Bus[] buses = {bus1, bus2};
        try (MockedStatic<Generated> mocked = Mockito.mockStatic(Generated.class)) {
            Random mockRandom = Mockito.mock(Random.class);
            Mockito.when(mockRandom.nextInt(strings.length)).thenReturn(0);
            mocked.when(() -> Generated.getInt(strings.length)).thenReturn(0);
            String s = Generated.generateFromList(strings);
            assertEquals("A", s);
            Integer i = Generated.generateFromList(ints);
            assertEquals(1, i);
            Bus bus = Generated.generateFromList(buses);
            assertEquals(bus1, bus);
        }*/
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 356})
    void generateNumber(int number) {
        /*try (MockedStatic<Generated> mocked = Mockito.mockStatic(Generated.class)) {
            Random mockRandom = Mockito.mock(Random.class);
            Mockito.when(mockRandom.nextInt(1)).thenReturn(0);
            mocked.when(() -> Generated.getInt(1)).thenReturn(0);
            int result = Generated.generateNumber(1, number);
            assertEquals(number, result);
        }*/
    }
}