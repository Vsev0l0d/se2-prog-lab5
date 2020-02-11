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
        Furnish furnish = furnishCheckingReader("Введите отделку (DESIGNER, NONE, FINE, BAD, LITTLE): ", is);
        View view = viewCheckingReader("Введите вид из квартиры (PARK, NORMAL, GOOD, TERRIBLE): ", is);
        Transport transport = transportCheckingReader("Введите транспот (FEW, NONE, LITTLE, NORMAL, ENOUGH): ", is);;
        String nameHouse = nameCheckingReader("Введите название дома: ", is);
        Long yearHouse = numberCheckingReader("Ввeдите год построки дома: ", is);
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

    public static Transport transportCheckingReader(String request, InputStream is){
        System.out.print(request);
        Scanner sc = new Scanner(is);
        Transport o = null;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                String s = sc.nextLine().trim();
                if (s.equals("")) return null;
                o = Transport.valueOf(s);
                resultOfChecking = true;
            } catch (IllegalArgumentException e) {
                System.out.println("не корректный ответ, воспользуйтесь списком в скобках");
                System.out.println("если хотите оставить поле пустым, нажмите Enter");
            }
        }
        return o;
    }

    public static Furnish furnishCheckingReader(String request, InputStream is){
        System.out.print(request);
        Scanner sc = new Scanner(is);
        Furnish o = null;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                String s = sc.nextLine().trim();
                if (s.equals("")) return null;
                o = Furnish.valueOf(s);
                resultOfChecking = true;
            } catch (IllegalArgumentException e) {
                System.out.println("не корректный ответ, воспользуйтесь списком в скобках");
                System.out.println("если хотите оставить поле пустым, нажмите Enter");
            }
        }
        return o;
    }

    public static View viewCheckingReader(String request, InputStream is){
        System.out.print(request);
        Scanner sc = new Scanner(is);
        View o = null;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                String s = sc.nextLine().trim();
                if (s.equals("")) return null;
                o = View.valueOf(s);
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
