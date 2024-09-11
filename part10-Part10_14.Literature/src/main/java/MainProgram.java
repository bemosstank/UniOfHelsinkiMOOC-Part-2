
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input the name of the book, empty stops:");
            String bookName = scanner.nextLine();   
            if (bookName.isEmpty()) {
                break;
            }
            System.out.println("Input the age recommendation: ");
            int age = Integer.parseInt(scanner.nextLine());
            

            list.add(new Book(bookName, age));
        }

        System.out.println(list.size() + " books in total.");
        
        Comparator<Book> comparable = Comparator
                .comparing(Book::getRecommendationAge)
                .thenComparing(Book::getBookName);
        
        Collections.sort(list, comparable);

        System.out.println();

        System.out.println("Books: ");

        for (Book book : list) {
            System.out.println(book);
        }
    }

}
