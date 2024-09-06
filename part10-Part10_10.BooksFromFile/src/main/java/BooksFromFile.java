
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        readBooks("books.txt").stream().forEach(books -> System.out.print(books.toString()));

    }

    public static List<Book> readBooks(String name) {
        List<Book> list = new ArrayList<>();
        try {
            Files.lines(Paths.get(name))
                    .map(parts -> parts.split(","))
                    .map(part -> new Book(part[0], Integer.parseInt(part[1]), Integer.parseInt(part[2]), part[3]))
                    .forEach(book -> list.add(book));
        } catch (IOException exe) {
            System.out.println("Error: " + exe.getMessage());
        }
        return list;
    }
}
