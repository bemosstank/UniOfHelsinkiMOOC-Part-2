/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ensia
 */
import java.util.Scanner;

public class Store {

    private Warehouse warehouse;
    private Scanner scan;

    public Store( Warehouse warehouse,Scanner scanner) {
        this.warehouse = warehouse;
        this.scan = scanner;
    }

    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");
        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }
        while (true) {
            System.out.println("What to put in the cart(Press enter to go to the register): ");
            String product = this.scan.nextLine();
            if(product.isEmpty()){
                break;
            }
            if(this.warehouse.stock(product) !=0){
                this.warehouse.take(product);
                cart.add(product, this.warehouse.price(product));
            }
        }
            System.out.println("your Shopping contents:");
            cart.print();
            System.out.println("total: " + cart.price());
        }
    }
