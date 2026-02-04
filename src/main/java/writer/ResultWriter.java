package writer;

public interface ResultWriter<T> {

    public void write(T obj);

    public void writeCollection(Iterable<? extends T> values);
}
