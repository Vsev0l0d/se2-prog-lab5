import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class MyCollection extends TreeSet{
    private TreeSet<Flat> flats = new TreeSet<Flat>();
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

    public List<Flat> toList() {
        return (List<Flat>) flats;
    }

}
