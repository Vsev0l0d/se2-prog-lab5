import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public abstract class CollectionManager {

    public static void help(MyCollection o, InputStream is, String[] arg) {
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

    public static void info(MyCollection o, InputStream is, String[] arg){
        if(checksForExtraArguments(arg)) return;
        System.out.println("Тип коллекции: " + o.getTypeCollection().getName());
        System.out.println("Дата инициализации коллекции: " + o.getCreationDate());
        System.out.println("Количество элементов коллекции: " + o.size());
    }

    public static void show(MyCollection o, InputStream is, String[] arg){
        if(checksForExtraArguments(arg)) return;
        if (!o.isEmpty()){
            for (Object i : o){
            o.display((Flat) i);
            }
        } else System.out.println("Коллекция не содержит элементов");
    }

    public static void add(MyCollection o, InputStream is, String[] arg){
        if(checksForExtraArguments(arg)) return;
       aadWithOutput(o, FlatReader.readFlat(is));
    }

    public static void update(MyCollection o, InputStream is, String[] arg){}

    public static void removeById(MyCollection o, InputStream is, String[] arg){
        if (arg.length < 1) {
            System.out.println("Нужен id");
            return;
        }
        long id;
        try {
            id = Long.parseLong(arg[0]);
        } catch (NumberFormatException e) {
            System.out.println("id должен быть натуральным числом");
            return;
        }
        TreeSet<Flat> buffer = new TreeSet<>();
        for (Object i : o){
            if(((Flat)i).getId() == id) buffer.add((Flat) i);
        }
        if(!buffer.isEmpty()){
            buffer.forEach(x -> removeWithOutput(o, x));
        } else System.out.println("Элемент с таким id не найден");
    }

    public static void clear(MyCollection o, InputStream is, String[] arg) {
        if(checksForExtraArguments(arg)) return;
        o.clear();
    }

    public static void save(MyCollection o, InputStream is, String[] arg){
//        if(checksForExtraArguments(arg)) return;
    }

    public static void executeScript(MyCollection o, InputStream is, String[] arg){ // не работает
        if (arg.length < 1) {
            System.out.println("Нужно полное имя файла");
            return;
        }
        String fileName = arg[0];
        FileInputStream f;
        try {
            File file = new File(fileName);
            f = new FileInputStream(file);
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден или не хватает прав для его чтения");
            return;
        }
        Scanner sc = new Scanner(f);
        BankCommand bankTeams = new BankCommand();
        try {
            while (sc.hasNextLine()){
                String[] arguments = sc.nextLine().trim().split(" ");
                if (arguments.length == 0) continue;
                if (arguments[0].equals("")) continue;
                String command = arguments[0];
                arguments = Arrays.copyOfRange(arguments, 1, arguments.length);

                if (bankTeams.commandMap.get(command) != null){
                    bankTeams.commandMap.get(command).accept(o, f, arguments);
                } else {
                    System.out.println("Ошибка в содержании файла");
                    return;
                }
            }
        } catch (NoSuchElementException e){
            System.out.println("Ошибка в содержании файла");
        }
    }

    public static void exit(MyCollection o, InputStream is, String[] arg){
        if(checksForExtraArguments(arg)) return;
        System.exit(0);
    }

    public static void addIfMin(MyCollection o, InputStream is, String[] arg){
        if(checksForExtraArguments(arg)) return;
        Flat flat = FlatReader.readFlat(is);
        try {
            if (((Flat)o.first()).compareTo(flat) > 0) {
                aadWithOutput(o, flat);
            } else System.out.println("Значение этого элемента больше, чем у наименьшего элемента коллекции");
        } catch (NoSuchElementException e){
            aadWithOutput(o, flat);
        }
    }

    public static void removeGreater(MyCollection o, InputStream is, String[] arg){
        if(checksForExtraArguments(arg)) return;
        Flat f = FlatReader.readFlat(is);
        TreeSet<Flat> buffer = new TreeSet<>();
        for (Object i : o) if (((Flat)i).compareTo(f) > 0) buffer.add((Flat) i);
        if(!buffer.isEmpty()){
            buffer.forEach(o::remove);
        } else System.out.println("\nЭлементов превышающие заданный не найдено\n");
    }

    public static void removeLower(MyCollection o, InputStream is, String[] arg){
        if(checksForExtraArguments(arg)) return;
        Flat f = FlatReader.readFlat(is);
        TreeSet<Flat> buffer = new TreeSet<>();
        for (Object i : o) if (((Flat)i).compareTo(f) < 0) buffer.add((Flat) i);
        if(!buffer.isEmpty()){
            buffer.forEach(o::remove);
        } else System.out.println("\nЭлементов меньшие, чем заданный не найдено\n");
    }

    public static void groupCountingByCreationDate(MyCollection o, InputStream is, String[] arg){
//        if(checksForExtraArguments(arg)) return;
    }

    public static void filterContainsName(MyCollection o, InputStream is, String[] arg){
        if (!o.isEmpty()){
            if (arg.length < 1) {
                System.out.println("Нужена подстрока");
                return;
            }
            String name = arg[0];
            int counter = 0;
            for (Object i : o){
               Flat flat = (Flat) i;
               if (flat.getName().contains(name)){
                   o.display(flat);
                   counter++;
               }
            }
            System.out.printf("Найдено %d элементов, название которых содержит '%s' \n", counter, name);
        } else System.out.println("Коллекция не содержит элементов");
    }

    public static void printFieldAscendingNumberOfRooms(MyCollection o, InputStream is, String[] arg){

    }

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

    private static void removeWithOutput(MyCollection o, Flat flat){
        boolean e = o.remove(flat);
        if (e){
            System.out.println("\nЭлемент успешно удален\n");
        } else {
            System.out.println("\nЭлемент не найден\n");
        }
    }
}
