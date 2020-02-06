import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String command;
        TreeSet<Flat> flats = new TreeSet<Flat>();

        Consumer r = new Consumer(1); // все что связано с Consumer пока что хрень
        HashMap<String, Consumer> commandMap = new HashMap<String, Consumer>();
        commandMap.put("help", r);
        commandMap.put("info", r);
        commandMap.put("show", r);
        commandMap.put("add", r);
        commandMap.put("update", r);
        commandMap.put("remove_by_id", r);
        commandMap.put("clear", r);
        commandMap.put("save", r);
        commandMap.put("execute_script", r);
//        commandMap.put("exit", r);
        commandMap.put("add_if_min", r);
        commandMap.put("remove_greater", r);
        commandMap.put("remove_lower", r);
        commandMap.put("group_counting_by_creation_date", r);
        commandMap.put("filter_contains_name", r);
        commandMap.put("print_field_ascending_number_of_rooms", r);

        do {
            command = sc.nextLine();
        } while(!command.equals("exit"));
    }
}
