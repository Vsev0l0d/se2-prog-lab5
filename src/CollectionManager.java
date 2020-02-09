import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public abstract class CollectionManager {

    public static void help(Object o) {
        try(FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src\\HelpAboutTeams.txt"))
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

    public static void info(Object o){}

    public static void show(Object o){}

    public static void add(Object o){}

    public static void update(Object o){}

    public static void removeById(Object o){}

    public static void clear(Object o){
        TreeSet<Flat> obj = (TreeSet<Flat>)o;
        obj.clear();
    }

    public static void save(Object o){}

    public static void executeScript(Object o){}

    public static void exit(Object o){
        System.exit(0);
    }

    public static void addIfMin(Object o){}

    public static void removeGreater(Object o){}

    public static void removeLower(Object o){}

    public static void groupCountingByCreationDate(Object o){}

    public static void filterContainsName(Object o){}

    public static void printFieldAscendingNumberOfRooms(Object o){}
}
