import java.io.FileReader;
import java.io.IOException;

public abstract class CollectionManager {

    public static void help(MyCollection o, String[] arg) {
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
        System.out.println("Тип коллекции: " + o.getTypeCollection().getName());
        System.out.println("Дата инициализации коллекции: " + o.getCreationDate());
        System.out.println("Количество элементов коллекции: " + o.size());
    }

    public static void show(MyCollection o, String[] arg){
        o.toList().stream().forEach(o::display);
    }

    public static void add(MyCollection o, String[] arg){
       boolean e = o.add(FlatReader.readFlat(System.in));
       if (e){
           System.out.println("\nЭлемент успешно добавлен\n");
       } else {
           System.out.println("\nТакой элемент уже есть\n");
       }
    }

    public static void update(MyCollection o, String[] arg){
//        if (arg.length < 1) {
//            System.out.println("Нужен id");
//            return;
//        }
//        int id;
//        try {
//            id = Integer.parseInt(arg[0]);
//        } catch (NumberFormatException e) {
//            System.out.println("id должен быть натуральным числом");
//            return;
//        }
//        try {
//            o.toList().stream().filter(x -> x.getId() == id);
//        } catch (ClassCastException e) {
//            System.out.println("Элемент с таким id не найден");
//        }
    }

    public static void removeById(MyCollection o, String[] arg){
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
        try {
            o.toList().stream().filter(x -> x.getId() == id).forEach(o::remove);
        } catch (ClassCastException e) {
            System.out.println("Элемент с таким id не найден");
        }
    }

    public static void clear(MyCollection o, String[] arg) {
        o.clear();
    }

    public static void save(MyCollection o, String[] arg){}

    public static void executeScript(MyCollection o, String[] arg){}

    public static void exit(MyCollection o, String[] arg){
        System.exit(0);
    }

    public static void addIfMin(MyCollection o, String[] arg){}

    public static void removeGreater(MyCollection o, String[] arg){
        Flat f = FlatReader.readFlat(System.in);
        o.tailSet(f, false).forEach(o::remove);
    }

    public static void removeLower(MyCollection o, String[] arg){
        Flat f = FlatReader.readFlat(System.in);
        o.headSet(f, false).forEach(o::remove);

    }

    public static void groupCountingByCreationDate(MyCollection o, String[] arg){}

    public static void filterContainsName(MyCollection o, String[] arg){}

    public static void printFieldAscendingNumberOfRooms(MyCollection o, String[] arg){}
}
