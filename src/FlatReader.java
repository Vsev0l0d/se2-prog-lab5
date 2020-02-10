import java.io.InputStream;
import java.util.Scanner;

public abstract class FlatReader {
    public static Flat readFlat(InputStream is){
        String name; //Поле не может быть null, Строка не может быть пустой
        Coordinates coordinates; //Поле не может быть null
        long area; //Значение поля должно быть больше 0
        Long numberOfRooms; //Значение поля должно быть больше 0
        Furnish furnish; //Поле не может быть null
        View view; //Поле может быть null
        Transport transport; //Поле может быть null
        House house; //Поле может быть null
//        return new Flat(name, coordinates, area, numberOfRooms, furnish, view, transport, house);

        return null;
    }

    public static Object verificationReader(InputStream is){
        Scanner sc = new Scanner(is);
        boolean resultOfChecking = false;


        return null;
    }
}
