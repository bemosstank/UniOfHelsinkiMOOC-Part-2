
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // you may try out your class here
        Hideout<String> den = new Hideout<>();
        System.out.println(den.isInHideOut());
        den.putIntoHideout("peakaboo");
        System.out.println(den.isInHideOut());
        System.out.println(den.takeFromHideout());
        System.out.println(den.isInHideOut());
        den.putIntoHideout("toodaloo");
        den.putIntoHideout("heelloo");
        System.out.println(den.isInHideOut());
        System.out.println(den.takeFromHideout());
        System.out.println(den.isInHideOut());
    }
}
