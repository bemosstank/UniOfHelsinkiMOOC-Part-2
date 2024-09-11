/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

/**
 *
 * @author ensia
 */
import java.util.*;
import FlightControl.domain.*;

public class FlightControl {

    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private Map<String, Place> places;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }

    public void addAirplane(String ID, int capacity) {
        this.airplanes.put(ID, new Airplane(ID, capacity));
    }

    public void addFlight(Airplane plane, String departureID, String destinationID) {
        this.places.putIfAbsent(departureID, new Place(departureID));
        this.places.putIfAbsent(destinationID, new Place(destinationID));
        
        this.flights.put(new Flight(plane, this.places.get(departureID), this.places.get(destinationID)).toString(), new Flight(plane, this.places.get(departureID), this.places.get(destinationID)));
    }
    
    public Collection<Airplane> getAirplances(){
       return this.airplanes.values();
    }
    
    public Collection<Flight> getFlights(){
        return this.flights.values();
    }
    
    public Airplane getAirplane(String ID){
        return this.airplanes.get(ID);
    }
    
}
