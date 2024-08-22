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

public class OneItemBox extends Box {

    private int capacity;
    private ArrayList<Item> list;

    public OneItemBox() {
        this.capacity = 1;
        this.list = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (this.list.isEmpty()) {
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
