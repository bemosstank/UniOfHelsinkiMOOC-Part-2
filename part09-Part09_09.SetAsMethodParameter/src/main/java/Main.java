
import java.util.Set;
import java.util.HashSet;
public class Main {

    public static void main(String[] args) {
        // You can test your method here
        Set<String> names = new HashSet<>();
        names.add("first");
        names.add("first");
        names.add("second");
        names.add("second");
        names.add("second");
        System.out.println(returnSize(names));

    }
    public static int returnSize(Set<String> names){
        return names.size();
    }

    // implement the method returnSize here, which returns
    // the number of elements in the set that it receives as a parameter.

}
