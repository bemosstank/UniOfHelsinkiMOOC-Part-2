/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;

/**
 *
 * @author ensia
 */
import FlightControl.logic.FlightControl;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import java.util.Scanner;

public class TextUI {

    private FlightControl flightControl;
    private Scanner scanner;

    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public void start() {
        this.airportAssetControl();
        System.out.println();
        this.flightControl();
        System.out.println();
    }

    private void airportAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();
        while (true) {
            System.out.println("Choose an action:\n"
                    + "[1] Add an airplane\n"
                    + "[2] Add a flight\n"
                    + "[x] Exit Airport Asset Control");
            System.out.println("> ");
            String answerInput = String.valueOf(this.scanner.next());
            if (answerInput.equals("1")) {
                this.addAirplane();
            } else if (answerInput.equals("2")) {
                this.addFlights();
            } else if (answerInput.equals("x")) {
                break;
            }
        }
    }

    public void addAirplane() {
        System.out.println("Give the airplane id: ");
        String planeID = String.valueOf(this.scanner.next());
        System.out.println("Give the airplane capacity: ");
        int planceCapacity = Integer.valueOf(this.scanner.next());
        this.flightControl.addAirplane(planeID, planceCapacity);
    }

    public void addFlights() {
        System.out.println("Give the airplane id: ");
        Airplane airplane = this.askForAirplane();
        System.out.println("Give the departure airport id: ");
        String departureID = String.valueOf(this.scanner.next());
        System.out.println("Give the target airport id: ");
        String destinationID = String.valueOf(this.scanner.next());
        this.flightControl.addFlight(airplane, departureID, destinationID);
    }

    private void flightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println("");
        System.out.println("choose action");
        while (true) {
            System.out.println("[1] Print airplanes\n"
                    + "[2] Print flights\n"
                    + "[3] Print airplane details\n"
                    + "[x] Quit");
            System.out.println(">");
            String answerInput = String.valueOf(this.scanner.next());
            if (answerInput.equals("1")) {
                this.prinAirPlanes();
            } else if (answerInput.equals("2")) {
                this.printFlights();
            } else if (answerInput.equals("3")) {
                this.printAirplaneDetails();
            } else if (answerInput.equals("x")) {
                break;
            }
        }
    }

    public void prinAirPlanes() {
        for (Airplane airplane : this.flightControl.getAirplances()) {
            System.out.println(airplane);
        }
    }

    public void printFlights() {
        for (Flight flight : this.flightControl.getFlights()) {
            System.out.println(flight);
        }
    }

    private void printAirplaneDetails() {
        System.out.println("Give the airplane id:");
        Airplane airplane = askForAirplane();
        System.out.println(airplane);
        System.out.println();
    }

    private Airplane askForAirplane() {
        Airplane airplane = null;
        while (airplane == null) {
            String planeID = String.valueOf(this.scanner.next());
            airplane = this.flightControl.getAirplane(planeID);
            if (airplane == null) {
                System.out.println("No airplane with id " + planeID + ".");
            }
        }
        return airplane;

    }
}
