import com.google.gson.*;

public abstract class ParserJson {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.serializeNulls().setPrettyPrinting().create();

    public static MyCollection parseFromJsonStringToCollection(String jsonString){
        return gson.fromJson(jsonString, MyCollection.class);
    }

    public static String parseFromCollectionToFromJsonString(MyCollection o){
        return gson.toJson(o);
    }
}
