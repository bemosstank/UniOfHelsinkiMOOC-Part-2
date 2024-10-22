
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many random numbers should be print");
        int number = Integer.parseInt(scanner.nextLine());
        int i =1;
        while(i <= number) {
            int randomNumber =ThreadLocalRandom.current().nextInt(11);
            System.out.println(randomNumber);
            i++;
        }
    }

}
