package collection;

import customCollections.CustomList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {

    private CustomList<Integer> list;

    static class TestEntity {
        private final int value;

        TestEntity(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof TestEntity that)) return false;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }


    @BeforeEach
    void setUp() {
        list = new CustomList<>();
    }

    @Test
    void addAndGet_shouldWorkCorrectly() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void get_outOfBounds_shouldThrowException() {
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void findAndContains_shouldWorkCorrectly() {
        Integer a = 5;
        Integer b = 5;

        list.add(a);

        assertTrue(list.contains(b));
        assertEquals(0, list.find(b));
    }

    @Test
    void find_notFound_shouldReturnMinusOne() {
        list.add(1);
        list.add(2);

        assertEquals(-1, list.find(3));
        assertFalse(list.contains(3));
    }

    @Test
    void remove_shouldShiftElements() {
        list.add(1);
        list.add(2);
        list.add(3);

        boolean removed = list.remove(2);

        assertTrue(removed);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void remove_notExisting_shouldReturnFalse() {
        list.add(1);

        assertFalse(list.remove(99));
        assertEquals(1, list.size());
    }

    @Test
    void grow_shouldIncreaseCapacityAndKeepElements() {
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        assertEquals(20, list.size());

        for (int i = 0; i < 20; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void iterator_shouldIterateOnlyRealElements() {
        list.add(1);
        list.add(2);
        list.add(3);

        int sum = 0;
        for (int i : list) {
            sum += i;
        }

        assertEquals(6, sum);
    }

    @Test
    void toStream_shouldCreateValidStream() {
        list.add(1);
        list.add(2);
        list.add(3);

        long count = list.toStream()
                .filter(i -> i > 1)
                .count();

        assertEquals(2, count);
    }

    @Test
    void parallelStream_shouldWorkCorrectly() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(1);

        long count = list.toStream()
                .parallel()
                .filter(i -> i == 1)
                .count();

        assertEquals(3, count);
    }

    @Test
    void find_shouldUseEqualsAndHashCodeContract() {
        CustomList<TestEntity> entityList = new CustomList<>();

        TestEntity a = new TestEntity(42);
        TestEntity b = new TestEntity(42); // equals == true, ссылки разные

        entityList.add(a);

        assertTrue(entityList.contains(b));
        assertEquals(0, entityList.find(b));
    }
}
