
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class LiteracyComparison {
    
    public static void main(String[] args) {
       readLines("literacy.csv").stream()
               .sorted((p1, p2) -> {
                   return Double.compare(Double.valueOf(p1[5]), Double.valueOf(p2[5]));
               }).forEach(lines -> System.out.println(lines[3] + " (" + lines[4] +"), " + lines[2] + ", " + lines[5]));
   
    }
    
    public static List<String[]> readLines(String fileName) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            Files.lines(Paths.get(fileName))
                    .map(line -> line.split(","))
                    .forEach(parts -> list.add(parts));
        }catch(IOException exe){
            System.out.println("Error: " + exe.getMessage());
        }
        
        for(String[] part : list) {
            part[2] = part[2].trim();
            String[] gender = part[2].split(" ");
            part[2] = gender[0];
            
        }
        return list;
    }
}
