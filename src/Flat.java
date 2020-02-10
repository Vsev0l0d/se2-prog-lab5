import java.time.LocalDate;

public class Flat implements Comparable<Flat>{
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDate creationDate;
    private long area;
    private Long numberOfRooms;
    private Furnish furnish;
    private View view;
    private Transport transport;
    private House house;
    private static int counterId = 0;

    public Flat(String name, Coordinates coordinates, long area, Long numberOfRooms, Furnish furnish, View view, Transport transport, House house) {
        this.id = counterId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.furnish = furnish;
        this.view = view;
        this.transport = transport;
        this.house = house;
    }

    public long getArea(){
        return area;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int compareTo(Flat o) {
        return this.id - o.getId();
    }
}
