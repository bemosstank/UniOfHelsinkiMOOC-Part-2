
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        while (this.numbers.size() < 7) {
            // Implement the random number generation here
            int randomNumber = ThreadLocalRandom.current().nextInt(1, 41);
            // the method containsNumber is probably useful
            if (!this.numbers.contains(randomNumber)) {
                
                this.numbers.add(randomNumber);
            }
        }

    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        boolean trueOrFalse = false;
        for(int randomNumber : this.numbers)
        if (randomNumber == number) {
            trueOrFalse = true;
        }
        return trueOrFalse;
    }
}
