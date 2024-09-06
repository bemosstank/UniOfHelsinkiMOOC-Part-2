
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       List<String> fileInput = read("newfile.txt");
        fileInput.stream()
                .collect(Collectors.toList());
        System.out.println(fileInput);

    }
    public static List<String>read(String file){
        List<String> row = new ArrayList<>();
        try{
            Files.lines(Paths.get(file))
                    .forEach(line -> row.add(line));
        }catch(IOException exe){
            System.out.println("Errror: " + exe.getMessage());
        }
        return row;
    }

}
