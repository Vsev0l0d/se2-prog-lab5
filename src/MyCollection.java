import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class MyCollection extends TreeSet{
    private TreeSet<Flat> flats = new TreeSet<Flat>(Comparator.comparing(Flat::getArea));
    private java.time.LocalDate creationDate;
    private int counterId;

    public MyCollection() {
        this.creationDate = LocalDate.now();
        this.counterId = 1;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Class<?> getTypeCollection(){
        return flats.getClass();
    }

    public void increaseCounterId() {
        counterId ++;
    }

    public List<Flat> toList() {
        return (List<Flat>) flats;
    }

}
