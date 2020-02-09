import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String command;
        TreeSet<Flat> flats = new TreeSet<Flat>();
        BankTeams bankTeams = new BankTeams();

        do {
            command = sc.nextLine();
            bankTeams.commandMap.get(command).accept(flats);
        } while(!command.equals("exit"));
        sc.close();
    }
}
