package writer;

public class ConsoleWriter<T> implements ResultWriter<T> {

    @Override
    public void write(T obj) {
        if (obj == null) {
            System.out.println("Объекта не существует.");
            return;
        }
        System.out.println(obj);
    }

    @Override
    public void writeCollection(Iterable<? extends T> values) {
        if (values == null) {
            System.out.println("Коллекции не существует.");
            return;
        }

        for (T value : values) {
            System.out.println(value.toString());
        }
    }
}
