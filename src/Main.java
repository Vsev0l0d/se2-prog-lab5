import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        TreeSet<Flat> flats = new TreeSet<Flat>();
        BankTeams bankTeams = new BankTeams();
        Scanner sc = new Scanner(System.in);
        String command;

        while (sc.hasNext()){
            command = sc.nextLine();

            if (bankTeams.commandMap.get(command) != null){
                bankTeams.commandMap.get(command).accept(flats);
            } else {
                System.out.println("я не знаю такой команды, воспользуйтесь командой help");
            }
        }
    }
}
