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

public class ChangeHistory {

    private ArrayList<Double> list;

    public ChangeHistory() {
        this.list = new ArrayList<>();
    }

    public void add(double status) {
        this.list.add(status);
    }

    public double maxValue() {
        double maxValue = 0;
        for (double number : this.list) {
            if (maxValue < number) {
                maxValue = number;
            }
        }
        return maxValue;
    }

    public double minValue() {
        if (this.list.isEmpty()) {
            return 0;
        }
        double miniValue =  999999999999.99;
        for(double number : this.list){
            if(miniValue > number){
                miniValue = number;
            }
        }
        return miniValue;
    }

    public void clear() {
        this.list.clear();
    }
    public double average(){
       double sum =0;
       int counter = 0;
       for(double number : this.list){
           sum = sum+number;
           counter = counter +1;
       }
       return (sum/counter);
    }
    @Override
    public String toString() {
        return this.list.toString();
    }
}
