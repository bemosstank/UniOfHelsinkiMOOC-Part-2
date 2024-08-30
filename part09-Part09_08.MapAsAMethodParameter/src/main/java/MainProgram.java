
import java.util.Map;
import java.util.HashMap;
public class MainProgram {

    public static void main(String[] args) {
        Map<String, String> names = new HashMap<>();
        names.put("1", "First");
        names.put("2", "Second");
        System.out.println(returnSize(names));

    }
    public static int returnSize(Map<String, String> names) {
        return names.size();
    }
    // Implement here a method returnSize, which takes a Map-object as a parameter 
    // and returns the size of the map object
}
