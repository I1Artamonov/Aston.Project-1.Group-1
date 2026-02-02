package writer;

import java.util.Objects;
import java.util.stream.StreamSupport;

public final class OccurrenceCounter {

    private OccurrenceCounter() {
    }

    public static <T> long countAndPrint(Iterable<T> data, T target) {
        Objects.requireNonNull(data, "data must not be null");

        long count = StreamSupport.stream(data.spliterator(), true)
                .filter(x -> Objects.equals(x, target))
                .count();

        System.out.println("Occurrences of " + target + ": " + count);
        return count;
    }

    public static <T> String buildMessage(Iterable<T> data, T target) {
        long count = StreamSupport.stream(data.spliterator(), true)
                .filter(x -> Objects.equals(x, target))
                .count();
        return "Occurrences of " + target + ": " + count;
    }
}