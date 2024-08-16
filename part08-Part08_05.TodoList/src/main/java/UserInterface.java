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

public class UserInterface {

    private Scanner scan;
    private TodoList todolist;

    public UserInterface(TodoList todoList, Scanner scanner) {
        this.scan = scanner;
        this.todolist = todoList;
    }

    public void userInterfaceStart() {
        this.start();
    }

    public void start() {
        while (true) {
            System.out.println("Command: ");
            String commandInput = this.scan.nextLine();
            if (commandInput.equals("stop")) {
                break;
            } else if (commandInput.equals("add")) {
                System.out.println("To add: ");
                String toAddInput = this.scan.nextLine();
                this.todolist.add(toAddInput);
            } else if (commandInput.equals("list")) {
                this.todolist.print();
            } else if (commandInput.equals("remove")) {
                System.out.println("which one is removed? ");
                int removeListInput = Integer.parseInt(this.scan.nextLine());
                this.todolist.remove(removeListInput);
            }
        }
    }
}
