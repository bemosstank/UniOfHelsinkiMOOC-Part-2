
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap<String, String> nicknames = new HashMap<>();
        nicknames.put("mattew", "matt");
        nicknames.put("michael", "mix");
        nicknames.put("arthur", "artie");
        System.out.println(nicknames.get("mattew"));
        System.out.println(nicknames.get("michael"));
        System.out.println(nicknames.get("arthur"));
    }

}
