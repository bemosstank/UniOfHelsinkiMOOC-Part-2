
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        // test your method here
        List<Integer> numbers = new ArrayList<>();
       for(int i =-5; i< 5; i++) {
           numbers.add(i);
       }
        System.out.println("Postive numbers are: " + PositiveNumbers.positive(numbers));
    }
    
    public static List<Integer>positive(List<Integer> numbers){
        List<Integer> positiveNumbers = numbers.stream()
                .filter(s -> s > 0)
                .collect(Collectors.toList());
        return positiveNumbers;
    }

}
