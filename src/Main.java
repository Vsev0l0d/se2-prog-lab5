import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        MyCollection collection = new MyCollection();
        BankCommand bankTeams = new BankCommand();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String[] arguments = sc.nextLine().split("\\s");
            if (arguments.length == 0) continue;
            String command = arguments[0];
            arguments = Arrays.copyOfRange(arguments, 1, arguments.length);

            if (bankTeams.commandMap.get(command) != null){
                bankTeams.commandMap.get(command).execute(collection, arguments);
            } else {
                System.out.println("я не знаю такой команды, воспользуйтесь командой help");
            }

        }
    }
}
