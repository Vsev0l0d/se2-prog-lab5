import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public abstract class CollectionManager {

    public static void help(TreeSet<Flat> o) {
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

    public static void info(TreeSet<Flat> o){}

    public static void show(TreeSet<Flat> o){}

    public static void add(TreeSet<Flat> o){}

    public static void update(TreeSet<Flat> o){}

    public static void removeById(TreeSet<Flat> o){}

    public static void clear(TreeSet<Flat> o){
        o.clear();
    }

    public static void save(TreeSet<Flat> o){}

    public static void executeScript(TreeSet<Flat> o){}

    public static void exit(TreeSet<Flat> o){
        System.exit(0);
    }

    public static void addIfMin(TreeSet<Flat> o){}

    public static void removeGreater(TreeSet<Flat> o){}

    public static void removeLower(TreeSet<Flat> o){}

    public static void groupCountingByCreationDate(TreeSet<Flat> o){}

    public static void filterContainsName(TreeSet<Flat> o){}

    public static void printFieldAscendingNumberOfRooms(TreeSet<Flat> o){}
}
