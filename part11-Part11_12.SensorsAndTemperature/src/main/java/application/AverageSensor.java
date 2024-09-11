/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author ensia
 */
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Integer> readings;
    private ArrayList<Sensor> sensors;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    @Override
    public void setOn() {
        for (Sensor sensor : this.sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : this.sensors) {
            sensor.setOff();
        }
    }
    
    @Override
    public boolean isOn(){
        for(Sensor sensor : this.sensors){
            if(!sensor.isOn()){
                return false;
            }
        }
        return true;
    }
    

    @Override
    public int read() {
        if(!this.isOn() || this.sensors.size() == 0){
            throw new IllegalStateException("Not all sensor are on");
        }
        
        int sum = 0;
        for (Sensor sensor : this.sensors) {
            sum +=sensor.read();
        }
        int average = sum / this.sensors.size();
        this.readings.add(average);
        return average;
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
}
