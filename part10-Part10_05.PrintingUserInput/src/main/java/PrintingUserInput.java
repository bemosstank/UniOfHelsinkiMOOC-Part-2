
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean trueOrFalse = true;
        while(trueOrFalse) {
            String userInput = scanner.nextLine();
            if(userInput.isEmpty()) {
                trueOrFalse = false;
            }
            
            list.add(userInput);
        }
        
        list.stream()
               .map(i-> i)
                .forEach(s-> System.out.println(s));

    }
}
