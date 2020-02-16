import com.google.gson.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * вся работа с json
 */
public abstract class ParserJson {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.serializeNulls().setPrettyPrinting().create();

    /**
     * @param fileInputStream поток из json файла
     * @return коллекцию типа MyCollection
     * @see MyCollection
     */
    public static MyCollection parseFromJsonToCollection(FileInputStream fileInputStream) throws IOException {
        MyCollection o = new MyCollection();
        int i=-1;
        StringBuilder s = new StringBuilder();
        while((i=fileInputStream.read())!=-1){
            s.append((char) i);
        }
        Map<String, List<Object>> map = new HashMap<>();
        map = (Map<String, List<Object>>) gson.fromJson(s.toString(), map.getClass());
        for (Map.Entry<String, List<Object>> entry : map.entrySet()) {
            o.setCollectionCreationDate(LocalDate.parse(entry.getKey()));
            for (Object element : entry.getValue()){
                Flat flat = gson.fromJson(element.toString(), Flat.class);
                o.add(flat);
            }
        }

        return o;
    }

    /**
     * @param o коллекцию типа MyCollection
     * @see MyCollection
     * @return строку json
     */
    public static String parseFromCollectionToFromJsonString(MyCollection o){
        List<Flat> list = new ArrayList<>();
        for (Object flat : o){
            list.add((Flat)flat);
        }
        Map<java.time.LocalDate, List<Flat>> map = new HashMap<>();
        map.put(o.getCollectionCreationDate(), list);
        return gson.toJson(map);
    }
}
