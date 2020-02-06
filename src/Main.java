import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String command;
        TreeSet<Flat> flats = new TreeSet<Flat>();

        do {

            command = sc.nextLine();
        } while(!command.equals("exit"));
    }
}
