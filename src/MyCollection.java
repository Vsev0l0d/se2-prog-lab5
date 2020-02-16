import java.time.LocalDate;
import java.util.TreeSet;

/**
 * свой тип коллекции, наследуется от TreeSet
 */
public class MyCollection extends TreeSet{
    /**
     * дата создания коллекции
     */
    private java.time.LocalDate collectionCreationDate;

    public MyCollection() {
        this.collectionCreationDate = LocalDate.now();
    }

    public LocalDate getCollectionCreationDate() {
        return collectionCreationDate;
    }

    public void setCollectionCreationDate(LocalDate collectionCreationDate) {
        this.collectionCreationDate = collectionCreationDate;
    }

    public Class<?> getTypeCollection(){
        return super.getClass().getSuperclass();
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
