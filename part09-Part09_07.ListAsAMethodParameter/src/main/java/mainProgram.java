
import java.util.List;
import java.util.ArrayList;
public class mainProgram {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        // test your method here
        names.add("First");
        names.add("Second");
        names.add("Third");
        System.out.println(returnSize(names));

    }

    // Implement here a method returnSize
    // which returns the size of the list given to it
    //as a parameter
    public static int returnSize(List<String> names) {
        return names.size();
    }
}
