/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.history = new ChangeHistory();
        this.setBalance(initialBalance);
        this.history.add(initialBalance);
        
    }
    @Override
    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        this.history.add(this.getBalance());
    }
    @Override
    public double takeFromWarehouse(double amount){
       double realValue  = super.takeFromWarehouse(amount);
       this.history.add(this.getBalance());
       return realValue;
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + this.getName() + "\n" +
                            "History: " + this.history.toString() + "\n" +
                            "Largest amount of product: " +  this.history.maxValue() +"\n" +
                            "Smallest amount of product: " + this.history.minValue() + "\n" +
                            "Average: " + this.history.average());      
    }
    public String history(){
        return this.history.toString();
    }
}
