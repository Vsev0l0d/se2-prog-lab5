import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String command;
        do {
            command = sc.nextLine();
        } while(!command.equals("exit"));
    }
}
