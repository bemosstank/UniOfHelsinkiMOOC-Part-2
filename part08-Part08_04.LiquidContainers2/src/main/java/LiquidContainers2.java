
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container firstContainer = new Container();
        Container secondContainer = new Container();
        while (true) {
            System.out.println("First: " + firstContainer);
            System.out.println("Second: " + secondContainer);
            String userInput = scan.nextLine();
            if (userInput.equals("quit")) {
                break;
            }
            String[] splitTextInput = userInput.split(" ");
            int amount = Integer.parseInt(splitTextInput[1]);
            if (splitTextInput[0].equals("add")) {
                firstContainer.add(amount);
            }
            if (splitTextInput[0].equals("remove")) {
                secondContainer.remove(amount);
            }

            if (splitTextInput[0].equals("move")) {
                if (amount > firstContainer.contains()) {
                    amount = firstContainer.contains();
                }
                firstContainer.remove(amount);
                secondContainer.add(amount);
            }
        }
    }

}
