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

public class Hideout<T> {

    private ArrayList<T> hideout;

    public Hideout() {
        this.hideout = new ArrayList<>();
    }

    public void putIntoHideout(T hide) {
        if (!this.hideout.isEmpty()) {
            this.hideout.clear();
        }

        this.hideout.add(hide);
    }

    public T takeFromHideout() {
        T tohide = this.hideout.get(0);
        this.hideout.clear();
        return tohide;
    }

    public boolean isInHideOut() {
        if (!this.hideout.isEmpty()) {
            return true;
        }
        return false;
    }
}
