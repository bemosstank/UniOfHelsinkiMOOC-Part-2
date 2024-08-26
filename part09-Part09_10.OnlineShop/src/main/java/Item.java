/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
public class Item {
    private String product;
    private int quantity;
    private int unitPrice;
    
    public Item(String product, int quantity, int unitPrice){
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    
    public int price(){
        return this.unitPrice*this.quantity;
    }
    
    public void increaseQuantity(){
        this.quantity++;
    }
    
    public String toString(){
        return this.product + ": " + this.quantity;
    }
}
