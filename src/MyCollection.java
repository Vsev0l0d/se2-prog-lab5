import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

public class MyCollection extends TreeSet{
    private TreeSet<Flat> flats = new TreeSet<Flat>(Comparator.comparing(Flat::getArea));
    private java.time.LocalDate creationDate;

    public MyCollection() {
        this.creationDate = LocalDate.now();
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Class<?> getTypeCollection(){
        return flats.getClass();
    }
}
