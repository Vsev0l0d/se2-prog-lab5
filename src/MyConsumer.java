import java.util.Scanner;
import java.util.TreeSet;

/**
 * интерфейс для методов реализующих команды
 * @param <M> коллекция с которой работает команда
 * @param <I> сканер, которым при необходимости команда считывает данные
 * @param <T> аргументы команды
 */
@FunctionalInterface
public interface MyConsumer<M extends TreeSet, I, T> {
    void accept(MyCollection o, Scanner sc, String[] arg);
}
