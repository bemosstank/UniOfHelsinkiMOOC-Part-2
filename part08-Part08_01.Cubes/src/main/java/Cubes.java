
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String wordInput = scanner.nextLine();
            if(wordInput.equals("end")) {
                break;
            }else {
                int wordToInteger = Integer.valueOf(wordInput);
                int result = (int)Math.pow(wordToInteger, 3);
                System.out.println(result);
            }
        }
    }
}
