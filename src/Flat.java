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
    private static int counterId = 1;

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

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public View getView() {
        return view;
    }

    public Transport getTransport() {
        return transport;
    }

    public House getHouse() {
        return house;
    }

    @Override
    public int compareTo(Flat o) {
        return this.id - o.getId();
    }
}
