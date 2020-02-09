import java.util.TreeSet;

@FunctionalInterface
public interface MyTypeConsumer {
    void execute(MyCollection o, String[] arg);
}
