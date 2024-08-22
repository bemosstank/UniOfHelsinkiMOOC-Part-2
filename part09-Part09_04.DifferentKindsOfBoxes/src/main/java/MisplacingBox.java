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

public class MisplacingBox extends Box {

    private ArrayList<Item> list;

    public MisplacingBox(){
        this.list = new ArrayList<>();
    }
    @Override
    public void add(Item item) {
        this.list.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }

}
