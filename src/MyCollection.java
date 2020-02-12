import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class MyCollection extends TreeSet{
    private TreeSet<Flat> flats = new TreeSet();
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

    public Set<Flat> toSet() {
        return flats;
    }

    public void display(Flat flat) {
        System.out.println("id элемента: " + flat.getId());
        System.out.println("Название: " + flat.getName());
        System.out.println("Подъезд: " + flat.getCoordinates().getX());
        System.out.println("Этаж: " + flat.getCoordinates().getY());
        System.out.println("Дата инициализации элемента: " + flat.getCreationDate());
        System.out.println("Площадь: " + flat.getArea());
        System.out.println("Количество комнат: " + flat.getNumberOfRooms());
        System.out.println("Отделка: " + toStringWithNull(flat.getFurnish()));
        System.out.println("Вид: " + toStringWithNull(flat.getView()));
        System.out.println("Транспорт: " + toStringWithNull(flat.getTransport()));
        System.out.println("Название дома: " + flat.getHouse().getName());
        System.out.println("Год построки дома: " + flat.getHouse().getYear());
        System.out.println("Количество квартир на этаже: " + flat.getHouse().getNumberOfFlatsOnFloor() + "\n");
    }

    private String toStringWithNull(Object o){
        if (o == null) return "отсутствует";
        return o.toString();
    }

}
