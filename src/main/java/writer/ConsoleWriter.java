package writer;
public class ConsoleWriter<T> implements ResultWriter<T> {

    @Override
    public void write(T obj) {
        if (obj == null) {
            return;
        }
        System.out.println(obj.toString());
    }

    @Override
    public void writeCollection(Iterable<? extends T> values) {
        if (values == null) {
            return;
        }

        for (T value : values) {
            System.out.println(value.toString());
        }
    }
}
