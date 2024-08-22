/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private ArrayList<Item> list;
    private int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        int actualWeight = this.capacity;
        for (Item addedItem : this.list) {
            actualWeight -= addedItem.getWeight();
        }
        if (item.getWeight() <= actualWeight) {
            this.list.add(item);
        }
    }

    @Override
    public boolean isInBox(Item comparedItem) {
        for (Item item : this.list) {
            if (item.equals(comparedItem)) {
                return true;
            }

        }
        return false;
    }
}
