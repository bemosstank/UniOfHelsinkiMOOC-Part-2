
public class MainProgram {

    public static void main(String[] args) {
        // test your classes here
        Employees university = new Employees();
         university.add(new Person("Petrus", Education.PHD));
         university.add(new Person("Arto", Education.HS));
         university.add(new Person("Elina", Education.PHD));
         university.print();
         System.out.println("");
        university.fire(Education.HS);
        university.print();
    }
}
