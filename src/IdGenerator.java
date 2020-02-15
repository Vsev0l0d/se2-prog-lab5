import java.util.HashSet;
import java.util.Random;

public abstract class IdGenerator {
    public static int generateId(MyCollection o){
        HashSet<Integer> hashSetId = new HashSet<>();
        if (o != null){
            for (Object i : o) {
                hashSetId.add(((Flat)i).getId());
            }
        }
        int id;
        do {
           id = new Random().nextInt(Integer.MAX_VALUE);;
        } while (!hashSetId.add(id));
        return id;
    }
}
