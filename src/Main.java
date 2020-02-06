import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String command;
        TreeSet<Flat> flats = new TreeSet<Flat>();


        HashMap<String, Consumer> commandMap = new HashMap<String, Consumer>();

        commandMap.put("help", );
        commandMap.put("info", );
        commandMap.put("show", );
        commandMap.put("add", );
        commandMap.put("update", );
        commandMap.put("remove_by_id", );

        Consumer<TreeSet> clear = x-> x.clear();
        commandMap.put("clear", clear);

        commandMap.put("save", );
        commandMap.put("execute_script", );
//        commandMap.put("exit", );
        commandMap.put("add_if_min", );
        commandMap.put("remove_greater", );
        commandMap.put("remove_lower", );
        commandMap.put("group_counting_by_creation_date", );
        commandMap.put("filter_contains_name", );
        commandMap.put("print_field_ascending_number_of_rooms", );

        do {
            command = sc.nextLine();
        } while(!command.equals("exit"));
    }
}
