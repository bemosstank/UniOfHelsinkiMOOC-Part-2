/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
public class CustomTacoBox implements TacoBox {

    private int numberOftacos;
    
    public CustomTacoBox(int tacos){
        this.numberOftacos = tacos;
    }
    
    public int tacosRemaining(){
        return numberOftacos;
    }
    
    public void eat(){
        if(this.numberOftacos > 0){
             this.numberOftacos = this.numberOftacos -1;
        }
    }
}
