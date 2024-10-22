package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                 System.out.println("Thank you!");
                break;
            }else if(command.equals("2")) {
                System.out.println("Adding a new todo");
                System.out.println("Enter a name:");
                String todoName = String.valueOf(this.scanner.nextLine());
                System.out.println("Enter a description");
                String todoDescription = String.valueOf(this.scanner.nextLine());
                this.database.add(new Todo(todoName, todoDescription, Boolean.FALSE));
            }else if(command.equals("3")) {
                System.out.println("which todo should be marked as done");
                int ID = Integer.parseInt(this.scanner.nextLine());
                this.database.markAsDone(ID);
            }else if(command.equals("1")) {
                System.out.println("Listing the database contents");
                System.out.println( this.database.list());
            }else if(command.equals("4")) {
                System.out.println("which todo should be removed? (give the id");
                int removeTodo = Integer.valueOf(this.scanner.nextLine());
                this.database.remove(removeTodo);
            }
            

            // implement the functionality here
        }

       
    }

}
