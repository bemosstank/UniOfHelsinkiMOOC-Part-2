/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
import java.util.*;

public class Box implements Packable {

    private ArrayList<Packable> list;
    private double capacity;

    public Box(double capacity) {
        this.list = new ArrayList<>();
        this.capacity = capacity;

    }

    public double weight() {
        double weight = 0.0;
        for (Packable packable : this.list) {
            weight = weight + packable.weight();
        }
        return weight;
    }
    
    public void add(Packable packable) {

        if (packable.weight() <= (this.capacity - this.weight())) {
            this.list.add(packable);
        }
    }

    @Override
    public String toString() {
        return "Box: " + this.list.size() + " items, " + "total weight " + this.weight() + " kg";
    }
}
