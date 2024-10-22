package title;


import javafx.application.Application;
import java.util.Scanner;
public class Main {
 

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a title for the Application:");
        String titleInput = String.valueOf(scan.nextLine());
        Application.launch(UserTitle.class, "--title=" + titleInput);
    }

}
