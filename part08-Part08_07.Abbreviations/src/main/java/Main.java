
public class Main {

    public static void main(String[] args) {
        // Test your program here!
        Abbreviations abbreviation = new Abbreviations();
        abbreviation.addAbbreviation("e.g.", "for example");
        abbreviation.addAbbreviation("etc.", "and so on");
        abbreviation.addAbbreviation("i.e", "more percisely"); 
       String text = "e.g. i.e etc lol";
       for(String part : text.split(" ")) {
           if(abbreviation.hasAbbreviation(part)) {
               part = abbreviation.findExplanationFor(part);
           }
           System.out.print(part);
           System.out.print(" ");
       }
        System.out.println();
    }
}
