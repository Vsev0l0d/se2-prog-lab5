import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        MyCollection collection = new MyCollection();
        BankTeams bankTeams = new BankTeams();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String[] arguments = sc.nextLine().split("\\s");
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
