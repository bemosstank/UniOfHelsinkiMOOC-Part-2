package FlightControl;

import java.util.Scanner;
import FlightControl.ui.TextUI;
import FlightControl.logic.FlightControl;
public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        Scanner scan = new Scanner(System.in);
        FlightControl flightControl = new FlightControl();
        TextUI ui = new TextUI(flightControl, scan);
        
        ui.start();
        
        
    }
}
