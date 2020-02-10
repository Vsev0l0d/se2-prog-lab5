import java.io.InputStream;
import java.util.Scanner;

public abstract class FlatReader {
    public static Flat readFlat(InputStream is){ // еще не читает enum
        System.out.print("Введите название квартиры: ");
        String name = nameCheckingReader(is);
        System.out.print("Введите подъезд: ");
        Long x = numberCheckingReader(is);
        System.out.print("Введите этаж: ");
        long y = numberCheckingReader(is);
        System.out.print("Введите площадь квартиры (в м^2): ");
        long area = numberCheckingReader(is);
        System.out.print("Введите количество комнат в квартире: ");
        Long numberOfRooms = numberCheckingReader(is);
        System.out.print("Введите отделку (DESIGNER, NONE, FINE, BAD, LITTLE): ");
        Furnish furnish = null; //Поле не может быть null
        System.out.print("Введите вид из квартиры (PARK, NORMAL, GOOD, TERRIBLE): ");
        View view = null; //Поле может быть null
        System.out.print("Введите транспот (FEW, NONE, LITTLE, NORMAL, ENOUGH): ");
        Transport transport = null; //Поле может быть null
        System.out.print("Введите название дома: ");
        String nameHouse = nameCheckingReader(is);
        System.out.print("Год построки дома: ");
        Long yearHouse = numberCheckingReader(is);
        System.out.print("Введите количество квартир на этаже: ");
        Long numberOfFlatsOnFloor = numberCheckingReader(is);
        return new Flat(name, new Coordinates(x,y), area, numberOfRooms, furnish, view, transport, new House(nameHouse, yearHouse, numberOfFlatsOnFloor));
    }

    public static long numberCheckingReader(InputStream is){
        Scanner sc = new Scanner(is);
        long o = 0;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                o = Long.parseLong(sc.nextLine());
                if (o > 0){
                    resultOfChecking = true;
                } else {
                    System.out.println("Вы должны ввести натуральное число, попробуйте снова");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы должны ввести натуральное число, попробуйте снова");
            }
        }

        return o;
    }

//    public static Object enumCheckingReader(InputStream is){
//        Scanner sc = new Scanner(is);
//        Object o;
//        boolean resultOfChecking = false;
//        while (!resultOfChecking){
//            try {
//                o = sc.nextLine();
//                resultOfChecking = true;
//            } catch (NumberFormatException e) {
//                System.out.println("id должен быть натуральным числом");
//            }
//        }
//
//        return o;
//    }

    public static String nameCheckingReader(InputStream is){
        Scanner sc = new Scanner(is);
        String o = "";
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            o = sc.nextLine();
            if (!o.trim().equals("")) {
                resultOfChecking = true;
            } else {
                System.out.println("Вы должны ввести не пустую строку, попробуйте еще раз");
            }
        }

        return o;
    }
}
