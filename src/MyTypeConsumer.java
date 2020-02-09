import java.util.TreeSet;

@FunctionalInterface
public interface MyTypeConsumer {
    void execute(TreeSet<Flat> o);
}
