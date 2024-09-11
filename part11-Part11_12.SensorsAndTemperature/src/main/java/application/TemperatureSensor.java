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
import java.util.concurrent.ThreadLocalRandom;
public class TemperatureSensor implements Sensor {

    private boolean state;

    public TemperatureSensor() {
        this.state = false;
    }

    @Override
    public boolean isOn() {
        return this.state;
    }
    
    @Override
    public void setOff(){
        this.state = false;
    }

    @Override
    public void setOn() {
        this.state = true;
    }

    @Override
    public int read() {
        if(!this.isOn()){
            throw new IllegalArgumentException("The sensor is off");
        }
        int random = ThreadLocalRandom.current().nextInt(61);
        return (random - 30);
    }
}
