package customCollections;
import lombok.EqualsAndHashCode;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@EqualsAndHashCode(callSuper = false)
public class CustomList<E> extends CustomCollection<E> implements Iterable<E> {

    private int capacity = 10;
    private Object[] elements;
    private int size = 0;

    public CustomList() {
        elements = new Object[capacity];
    }

    public CustomList(E element) {
        this();
        add(element);

    }

    public CustomList(CustomList<E> other) {
        this.capacity = other.capacity;
        this.size = other.size;
        this.elements = Arrays.copyOf(other.elements, other.capacity);
    }


    private boolean needGrow() {
        return size >= capacity * 0.8;
    }

    private void grow() {
        capacity *= 2;
        elements = Arrays.copyOf(this.toStream().toArray(), capacity);
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        if (needGrow()) grow();
        elements[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " out of bounds for size " + size
            );
        }
        return (E) elements[index];
    }

    public int find(E obj) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == obj) return i;
            if (elements[i] != null && obj != null) {
                if (elements[i].hashCode() == obj.hashCode() && elements[i].equals(obj)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(E obj) {
        return find(obj) != -1;
    }

    public boolean remove(E obj) {
        int index = find(obj);
        if (index == -1) return false;

        if (size - 1 - index >= 0) {
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        }

        elements[size - 1] = null;
        size--;
        return true;
    }

    public Stream<E> toStream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (E) elements[currentIndex++];
            }
        };
    }

    public void countOccurrencesParallel(E n) {
        long count = this.toStream()
                .parallel()
                .filter(e -> Objects.equals(e, n))
                .count();
        System.out.println("Количество вхождений элемента " + n + ": " + count);
    }

}
