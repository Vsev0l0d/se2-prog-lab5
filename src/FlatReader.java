import java.io.InputStream;
import java.util.Scanner;

public abstract class FlatReader {
    public static Flat readFlat(InputStream is){
        String buffer;
        String name = nameCheckingReader("Введите название квартиры: ", is);
        Long x = numberCheckingReader("Введите подъезд: ", is);
        long y = numberCheckingReader("Введите этаж: ", is);
        long area = numberCheckingReader("Введите площадь квартиры (в м^2): ", is);
        Long numberOfRooms = numberCheckingReader("Введите количество комнат в квартире: ", is);
        buffer = enumCheckingReader("Введите отделку (DESIGNER, NONE, FINE, BAD, LITTLE): ", is, "Furnish");
        Furnish furnish = null;
        if (buffer != null) furnish = Furnish.valueOf(buffer);
        buffer = enumCheckingReader("Введите вид из квартиры (PARK, NORMAL, GOOD, TERRIBLE): ", is, "View");
        View view = null;
        if (buffer != null) view = View.valueOf(buffer);
        buffer = enumCheckingReader("Введите транспот (FEW, NONE, LITTLE, NORMAL, ENOUGH): ", is, "Transport");
        Transport transport = null;
        if (buffer != null) transport = Transport.valueOf(buffer);
        String nameHouse = nameCheckingReader("Введите название дома: ", is);
        Long yearHouse = numberCheckingReader("Год построки дома: ", is);
        Long numberOfFlatsOnFloor = numberCheckingReader("Введите количество квартир на этаже: ", is);
        return new Flat(name, new Coordinates(x,y), area, numberOfRooms, furnish, view, transport, new House(nameHouse, yearHouse, numberOfFlatsOnFloor));
    }

    public static long numberCheckingReader(String request, InputStream is){
        System.out.print(request);
        Scanner sc = new Scanner(is);
        long o = 0;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                o = Long.parseLong(sc.nextLine().trim());
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

    public static String enumCheckingReader(String request, InputStream is, String nameEnum){
        System.out.print(request);
        Scanner sc = new Scanner(is);
        String o = null;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                o = sc.nextLine().trim();
                if (o.equals("")) return null;
                String copyO = o;
                switch (nameEnum){
                    case "Transport":
                        Transport.valueOf(copyO);
                        break;
                    case "View":
                        View.valueOf(copyO);
                        break;
                    case "Furnish":
                        Furnish.valueOf(copyO);
                        break;
                }
                resultOfChecking = true;
            } catch (IllegalArgumentException e) {
                System.out.println("не корректный ответ, воспользуйтесь списком в скобках");
                System.out.println("если хотите оставить поле пустым, нажмите Enter");
            }
        }
        return o;
    }

    public static String nameCheckingReader(String request, InputStream is){
        System.out.print(request);
        Scanner sc = new Scanner(is);
        String o = "";
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            o = sc.nextLine().trim();
            if (!o.equals("")) {
                resultOfChecking = true;
            } else {
                System.out.println("Вы должны ввести не пустую строку, попробуйте еще раз");
            }
        }

        return o;
    }
}
