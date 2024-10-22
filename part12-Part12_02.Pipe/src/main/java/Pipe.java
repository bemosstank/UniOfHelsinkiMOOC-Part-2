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

public class Pipe<T> {

    private ArrayList<T> listOfPipe;

    public Pipe() {
        this.listOfPipe = new ArrayList<>();
    }

    public void putInPipe(T value) {
        this.listOfPipe.add(value);
    }

    public T takeFromFile() {
        if (this.listOfPipe.isEmpty()) {
            return null;
        }
        T value = this.listOfPipe.get(0);
        this.listOfPipe.remove(0);
        return value;
    }
    
    public boolean isInPipe(){
        if(!this.listOfPipe.isEmpty()){
            return true;
        }
        return false;
    }
}
