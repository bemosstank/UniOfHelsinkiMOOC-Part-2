
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        while (true) {
            int userInput = Integer.parseInt(scanner.nextLine());
            if (userInput == 0) {
                if (sum > 0) {
                    System.out.println(1.0 * sum / count);
                } else {
                    System.out.println("Cannot calculate the average");
                    
                }
                break;
            } 
            if (userInput > 0) {
                sum = sum + userInput;
                count++;
            }
        }
    }
}
