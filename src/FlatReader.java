import java.util.Scanner;

/**
 * считывает и валидирует составной тип данных Flat, и составные типы данных содержащиеся во Flat
 */
public abstract class FlatReader {
    private static String[] forbiddenSubstrings = {"}", ",", ":", "]", "\"", "\\", "'", "/"};
    private static boolean errorFound = false;

    public static Flat readFlat(Scanner sc, MyCollection owner){
        errorFound = false;
        String name = nameCheckingReader("Введите название квартиры: ", sc);
        Long x = numberCheckingReader("Введите подъезд: ", sc);
        long y = numberCheckingReader("Введите этаж: ", sc);
        long area = numberCheckingReader("Введите площадь квартиры (в м^2): ", sc);
        Long numberOfRooms = numberCheckingReader("Введите количество комнат в квартире: ", sc);
        Furnish furnish = furnishCheckingReader("Введите отделку (DESIGNER, NONE, FINE, BAD, LITTLE): ", sc);
        View view = viewCheckingReader("Введите вид из квартиры (PARK, NORMAL, GOOD, TERRIBLE): ", sc);
        Transport transport = transportCheckingReader("Введите транспот (FEW, NONE, LITTLE, NORMAL, ENOUGH): ", sc);;
        String nameHouse = nameCheckingReader("Введите название дома: ", sc);
        Long yearHouse = numberCheckingReader("Введите год построки дома: ", sc);
        Long numberOfFlatsOnFloor = numberCheckingReader("Введите количество квартир на этаже: ", sc);
        if (errorFound) return null;
        return new Flat(name, new Coordinates(x,y), area, numberOfRooms, furnish, view, transport, new House(nameHouse, yearHouse, numberOfFlatsOnFloor), owner);
    }

    public static long numberCheckingReader(String request, Scanner sc){
        if (!Main.isScriptRunning()) System.out.print(request);
        long o = 0;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                o = Long.parseLong(sc.nextLine().trim());
                if (o > 0){
                    resultOfChecking = true;
                } else {
                    if (Main.isScriptRunning()){
                        errorFound = true;
                        return 0;
                    }
                    System.out.println("Вы должны ввести натуральное число, попробуйте снова");
                }
            } catch (NumberFormatException e) {
                if (Main.isScriptRunning()){
                    errorFound = true;
                    return 0;
                }
                System.out.println("Вы должны ввести натуральное число, попробуйте снова");
            }
        }

        return o;
    }

    public static Transport transportCheckingReader(String request, Scanner sc){
        if (!Main.isScriptRunning()) System.out.print(request);
        Transport o = null;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                String s = sc.nextLine().trim();
                if (s.equals("")) return null;
                o = Transport.valueOf(s);
                resultOfChecking = true;
            } catch (IllegalArgumentException e) {
                if (Main.isScriptRunning()){
                    errorFound = true;
                    return Transport.LITTLE;
                }
                System.out.println("не корректный ответ, воспользуйтесь списком в скобках");
                System.out.println("если хотите оставить поле пустым, нажмите Enter");
            }
        }
        return o;
    }

    public static Furnish furnishCheckingReader(String request, Scanner sc){
        if (!Main.isScriptRunning()) System.out.print(request);
        Furnish o = null;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                String s = sc.nextLine().trim();
                o = Furnish.valueOf(s);
                resultOfChecking = true;
            } catch (IllegalArgumentException e) {
                if (Main.isScriptRunning()){
                    errorFound = true;
                    return Furnish.BAD;
                }
                System.out.println("не корректный ответ, воспользуйтесь списком в скобках");
            }
        }
        return o;
    }

    public static View viewCheckingReader(String request, Scanner sc){
        if (!Main.isScriptRunning()) System.out.print(request);
        View o = null;
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            try {
                String s = sc.nextLine().trim();
                if (s.equals("")) return null;
                o = View.valueOf(s);
                resultOfChecking = true;
            } catch (IllegalArgumentException e) {
                if (Main.isScriptRunning()){
                    errorFound = true;
                    return View.NORMAL;
                }
                System.out.println("не корректный ответ, воспользуйтесь списком в скобках");
                System.out.println("если хотите оставить поле пустым, нажмите Enter");
            }
        }
        return o;
    }

    public static String nameCheckingReader(String request, Scanner sc){
        if (!Main.isScriptRunning()) System.out.print(request);
        String o = "";
        boolean resultOfChecking = false;
        while (!resultOfChecking){
            o = sc.nextLine().trim();
            if (!o.equals("")) {
                for (String s : forbiddenSubstrings){
                    if (!o.contains(s)){
                        resultOfChecking = true;
                    } else {
                        if (Main.isScriptRunning()){
                            errorFound = true;
                            return "q";
                        }
                        System.out.println("Вы использовали запрещенную строку или символ, попробуйте еще раз");
                    }
                }
            } else {
                if (Main.isScriptRunning()){
                    errorFound = true;
                    return "q";
                }
                System.out.println("Вы должны ввести не пустую строку, попробуйте еще раз");
            }
        }

        return o;
    }
}
