import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static File workFile;
    public static void main(String[] args){
        if (args.length < 1) {
            System.out.println("Вы не ввели полное имя файла, коллекция не будет загруженна в программу, так же вы не сможете ее сохранить");
        } else {
            String fileName = args[0];
            FileInputStream f;
            try {
                workFile = new File(fileName);
                f = new FileInputStream(workFile);
            } catch (FileNotFoundException e){
                System.out.println("Файл не найден или не хватает прав для его чтения, коллекция не будет загруженна в программу, так же вы не сможете ее сохранить");
            }
        }
//        MyCollection collection = ParserJson.parseFromJsonStringToCollection("[{\"id\":745736232,\"name\":\"1\",\"coordinates\":{\"x\":1,\"y\":1},\"creationDate\":{\"year\":2020,\"month\":2,\"day\":15},\"area\":1,\"numberOfRooms\":1,\"furnish\":\"BAD\",\"view\":null,\"transport\":null,\"house\":{\"name\":\"1\",\"year\":1,\"numberOfFlatsOnFloor\":1}}]");
        MyCollection collection = new MyCollection();
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
