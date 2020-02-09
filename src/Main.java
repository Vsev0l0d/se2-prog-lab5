import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    private static String inputLine;
    private static String[] inputWord;

    public static String[] getInputWord() {
        return inputWord;
    }

    public static void main(String[] args){
        TreeSet<Flat> flats = new TreeSet<Flat>();
        BankTeams bankTeams = new BankTeams();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            inputLine = sc.nextLine();
            inputWord = inputLine.split("\\s");

            if (bankTeams.commandMap.get(inputWord[0]) != null){
                bankTeams.commandMap.get(inputWord[0]).accept(flats);
            } else {
                System.out.println("я не знаю такой команды, воспользуйтесь командой help");
            }
        }
    }
}
