
public class Main {

    public static void main(String[] args) {
        // Test your program here
        IOU mattIOU = new IOU();
        mattIOU.setSum("Arthur", 51.5);
        mattIOU.setSum("Michael", 30);
        System.out.println(mattIOU.howMuchDoIOweTo("Arthur"));
        System.out.println(mattIOU.howMuchDoIOweTo("Michael"));
        
    }
}
