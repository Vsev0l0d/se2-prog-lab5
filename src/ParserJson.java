import com.google.gson.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ParserJson {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.serializeNulls().setPrettyPrinting().create();

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
            for (Object flat : entry.getValue()){
                o.add(flat);
            }
        }

        return o;
    }

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
