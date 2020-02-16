import com.google.gson.JsonSyntaxException;
import java.io.*;
import java.util.*;

/**
 * основной класс, содержит метод main для запуска программы
 */
public class Main {
    private static File workFile = new File(System.getProperty("user.dir")+"\\WorkFile");
    public static void main(String[] args){
        FileInputStream f = null;
        String workFilePath = System.getenv("WORK_FILE_PATH");

        if (workFilePath == null) {
            System.out.println("Вы не задали значение переменной окружения, коллекция будет загруженна из default файла, и сохранена в него же");
            try {
                f = new FileInputStream(workFile);
            } catch (FileNotFoundException e){
                System.out.println("Проблеммы с default файлом, коллекция не будет загруженна");
            }
        } else {
            try {
                workFile = new File(workFilePath);
                f = new FileInputStream(workFile);
            } catch (FileNotFoundException e){
                System.out.println("Файл не найден или не хватает прав для его чтения, коллекция не будет загруженна в программу, но вы сможете ее сохранить, если есть права на запись, если файла не существует, он будет создан");
            }
        }

        MyCollection collection;
        if (f != null){
            try {
                collection = ParserJson.parseFromJsonToCollection(f);
                System.out.println("Коллекция загружена\n");
            } catch (IOException | JsonSyntaxException e) {
                System.out.println("Ошибка при загрузке коллекции: " + e);
                collection = new MyCollection();
                System.out.println("Создана новая пустая коллекция\n");
            }
        } else {
            collection = new MyCollection();
            System.out.println("Создана новая пустая коллекция\n");
        }

        BankCommand bankCommand = new BankCommand();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String[] arguments = sc.nextLine().trim().split(" ");
            if (arguments.length == 0) continue;
            if (arguments[0].equals("")) continue;
            String command = arguments[0];
            arguments = Arrays.copyOfRange(arguments, 1, arguments.length);

            if (bankCommand.commandMap.get(command) != null){
                bankCommand.commandMap.get(command).accept(collection, System.in, arguments);
            } else {
                System.out.println("я не знаю такой команды, воспользуйтесь командой help");
            }
        }
    }

    public static File getWorkFile() {
        return workFile;
    }
}
