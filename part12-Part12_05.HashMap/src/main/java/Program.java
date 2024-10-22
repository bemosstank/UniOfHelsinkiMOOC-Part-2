
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
        HashMap<String, Integer> map = new HashMap<>();
        map.add("test1", 1);
        map.add("test2", 2);
        System.out.println(map.get("test2"));
        System.out.println(map.get("test1"));
        System.out.println(map.remove("test1"));
        System.out.println(map.get("test1"));
    }

}
