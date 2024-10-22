
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // you may try out your class here
        Pipe<String> pipe = new Pipe<>();
        pipe.putInPipe("dibi");
        pipe.putInPipe("dab");
        pipe.putInPipe("dab");
        pipe.putInPipe("daa");
        while(pipe.isInPipe()){
            System.out.println(pipe.takeFromFile());
        }

    }
}
