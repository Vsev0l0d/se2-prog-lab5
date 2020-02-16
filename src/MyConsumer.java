import java.io.InputStream;
import java.util.TreeSet;

/**
 * интерфейс для методов реализующих команды
 * @param <M> коллекция с которой работает команда
 * @param <I> поток откуда при необходимости команда считывает данные
 * @param <T> аргументы команды
 */
@FunctionalInterface
public interface MyConsumer<M extends TreeSet, I, T> {
    void accept(MyCollection o, InputStream is, String[] arg);
}
