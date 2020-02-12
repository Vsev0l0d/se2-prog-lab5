import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class CollectionManager {

    public static void help(MyCollection o, String[] arg) {
        if(checksForExtraArguments(arg)) return;
        try(FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src\\HelpAboutCommand.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void info(MyCollection o, String[] arg){
        if(checksForExtraArguments(arg)) return;
        System.out.println("Тип коллекции: " + o.getTypeCollection().getName());
        System.out.println("Дата инициализации коллекции: " + o.getCreationDate());
        System.out.println("Количество элементов коллекции: " + o.size());
    }

    public static void show(MyCollection o, String[] arg){
        if(checksForExtraArguments(arg)) return;
        if (!o.isEmpty()){
            for (Object i : o){
            o.display((Flat) i);
            }
        } else System.out.println("Коллекция не содержит элементов");
    }

    public static void add(MyCollection o, String[] arg){
        if(checksForExtraArguments(arg)) return;
       aadWithOutput(o, FlatReader.readFlat(System.in));
    }

    public static void update(MyCollection o, String[] arg){}

    public static void removeById(MyCollection o, String[] arg){ // не работает
        if (arg.length < 1) {
            System.out.println("Нужен id");
            return;
        }
        int id;
        try {
            id = Integer.parseInt(arg[0]);
        } catch (NumberFormatException e) {
            System.out.println("id должен быть натуральным числом");
            return;
        }
        Set<Flat> buffer = o.toSet().stream().filter(x -> x.getId() == id).collect(Collectors.toSet()); // судя по всему всегда пустая коллекция
        if(!buffer.isEmpty()){
            buffer.forEach(o::remove);
        } else System.out.println("Элемент с таким id не найден");
    }

    public static void clear(MyCollection o, String[] arg) {
        if(checksForExtraArguments(arg)) return;
        o.clear();
    }

    public static void save(MyCollection o, String[] arg){
//        if(checksForExtraArguments(arg)) return;
    }

    public static void executeScript(MyCollection o, String[] arg){
//        if(checksForExtraArguments(arg)) return;
    }

    public static void exit(MyCollection o, String[] arg){
        if(checksForExtraArguments(arg)) return;
        System.exit(0);
    }

    public static void addIfMin(MyCollection o, String[] arg){
        if(checksForExtraArguments(arg)) return;
        Flat flat = FlatReader.readFlat(System.in);
        try {
            if (((Flat)o.first()).compareTo(flat) > 0) {
                aadWithOutput(o, flat);
            } else System.out.println("Значение этого элемента больше, чем у наименьшего элемента коллекции");
        } catch (NoSuchElementException e){
            aadWithOutput(o, flat);
        }
    }

    public static void removeGreater(MyCollection o, String[] arg){
        if(checksForExtraArguments(arg)) return;
        Flat f = FlatReader.readFlat(System.in);
        o.tailSet(f, false).forEach(x -> o.remove((Flat)x));
    }

    public static void removeLower(MyCollection o, String[] arg){
        if(checksForExtraArguments(arg)) return;
        Flat f = FlatReader.readFlat(System.in);
        o.headSet(f, false).forEach(x -> o.remove((Flat)x));

    }

    public static void groupCountingByCreationDate(MyCollection o, String[] arg){
//        if(checksForExtraArguments(arg)) return;
    }

    public static void filterContainsName(MyCollection o, String[] arg){}

    public static void printFieldAscendingNumberOfRooms(MyCollection o, String[] arg){}

    private static boolean checksForExtraArguments(String[] arg){
        if (arg.length != 0){
            System.out.println("Для этой команды не нужны аргументы");
            return true;
        }
        return false;
    }

    private static void aadWithOutput(MyCollection o, Flat flat){
        boolean e = o.add(flat);
        if (e){
            System.out.println("\nЭлемент успешно добавлен\n");
        } else {
            System.out.println("\nТакой элемент уже есть\n");
        }
    }
}
