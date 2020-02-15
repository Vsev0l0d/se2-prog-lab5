import java.io.InputStream;
import java.util.HashMap;

public class BankCommand {
    HashMap<String, MyConsumer<MyCollection, InputStream, String[]>> commandMap = new HashMap();
    public BankCommand(){
        commandMap.put("help", CollectionManager::help);
        commandMap.put("info", CollectionManager::info);
        commandMap.put("show", CollectionManager::show);
        commandMap.put("add", CollectionManager::add);
        commandMap.put("update", CollectionManager::update);
        commandMap.put("remove_by_id", CollectionManager::removeById);
        commandMap.put("clear", CollectionManager::clear);
        commandMap.put("save", CollectionManager::save);
        commandMap.put("execute_script", CollectionManager::executeScript);
        commandMap.put("exit", CollectionManager::exit);
        commandMap.put("add_if_min", CollectionManager::addIfMin);
        commandMap.put("remove_greater", CollectionManager::removeGreater);
        commandMap.put("remove_lower", CollectionManager::removeLower);
        commandMap.put("group_counting_by_creation_date", CollectionManager::groupCountingByCreationDate);
        commandMap.put("filter_contains_name", CollectionManager::filterContainsName);
        commandMap.put("print_field_ascending_number_of_rooms", CollectionManager::printFieldAscendingNumberOfRooms);
    }
}
