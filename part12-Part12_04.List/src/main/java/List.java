/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
public class List<Type> {

    private Type[] value;
    private int indexing;

    public List() {
        this.value = (Type[]) new Object[10];
        this.indexing = 0;

    }

    public void add(Type value) {
        if (this.indexing == this.value.length) {
            this.grow();
        }
        this.value[this.indexing] = value;
        this.indexing = this.indexing + 1;
    }

    public void grow() {
        int newSize = this.value.length + this.value.length / 2;
        Type[] newArray = (Type[]) new Object[newSize];
        for (int i = 0; i < this.value.length; i++) {
            newArray[i] = this.value[i];
        }
        this.value = newArray;
    }

    public int indexOfValue(Type value) {
        for (int i = 0; i < this.indexing; i++) {
            if (this.value[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Type value) {
        return this.indexOfValue(value) >= 0;
    }

    public int getSize() {
        return this.indexing;
    }

    public void remove(Type value) {
        int found = this.indexOfValue(value);
        if (found < 0) {
            return;
        }
        this.moveToTheLeft(found);
        this.indexing = this.indexing - 1;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.indexing - 1; i++) {
            this.value[i] = this.value[i + 1];
        }
    }

    public Type value(int index) {
        if(index < 0 || index >= this.indexing) {
        throw new ArrayIndexOutOfBoundsException("index " + index + " outside of [0, " + this.indexing + "]");
    }
        return this.value[index];
    }
    
        
}
