import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String command;
        TreeSet<Flat> flats = new TreeSet<Flat>();

        do {
            command = sc.nextLine();
            switch (command){
                case ("help"):

                    break;
                case ("info"):

                    break;
                case ("show"):

                    break;
                case ("add"):

                    break;
                case ("update"):

                    break;
                case ("remove_by_id"):

                    break;
                case ("clear"):
                    flats.clear();
                    break;
                case ("save"):

                    break;
                case ("execute_script"):

                    break;
                case ("add_if_min"):

                    break;
                case ("remove_greater"):

                    break;
                case ("remove_lower"):

                    break;
                case ("group_counting_by_creation_date"):

                    break;
                case ("filter_contains_name"):

                    break;
                case ("print_field_ascending_number_of_rooms"):

                    break;
                default:

                    break;
            }
        } while(!command.equals("exit"));
    }
}
