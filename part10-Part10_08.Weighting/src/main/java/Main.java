

public class Main {

    public static void main(String[] args) {
        // Use this main program for testing your classes!
        Suitcase suitcase = new Suitcase(100);
        suitcase.addItem(new Item("first suitcase", 10));
        suitcase.addItem(new Item("second suitcase", 20));
        suitcase.addItem(new Item("second suitcase", 30));
        System.out.println(suitcase.totalWeight());
        suitcase.printItems();
        System.out.println(suitcase.heaviestItem());
    }

}
