
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class AverageOfNumbers {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        System.out.println("Input numbers, type " + "end " + "to stop.");
        while (true) {
            String userInput = scanner.nextLine();
            
            if(userInput.equals("end")){
                break;
            }
             list.add(userInput);
            
        }
        double average = list.stream()
                .mapToInt(s -> Integer.parseInt(s))
                .average()
                .getAsDouble();
        System.out.println("average of the numbers: " + average);
       
    }
}
