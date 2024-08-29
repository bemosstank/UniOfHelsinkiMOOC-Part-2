
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Input numbers, type end to stop.");
        while(true){
            String userInput = scanner.nextLine();
            if(userInput.equals("end")) {
                break;
            }
            
            list.add(userInput);
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers?");
        String postiveOrNegativeInput = scanner.nextLine();
        if(postiveOrNegativeInput.equals("p" )){
            double average = list.stream()
                    .mapToInt(s -> Integer.parseInt(s))
                    .filter(s-> (s > 0))
                    .average()
                    .getAsDouble();
            System.out.println("Average of the postive numbers: "+ average);
        }else if(postiveOrNegativeInput.equals("n")) {
            double average = list.stream()
                    .mapToInt(s-> Integer.parseInt(s))
                    .filter(s -> s <0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        }
    }
}
