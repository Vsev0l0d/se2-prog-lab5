import java.io.InputStream;
import java.util.TreeSet;

@FunctionalInterface
public interface MyConsumer<M extends TreeSet, I, T> {
    void accept(MyCollection o, InputStream is, String[] arg);
}
