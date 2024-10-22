
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int currentRow = 0;
        int currentColumn = size / 2;
        square.placeValue(currentColumn, currentRow, 1);

        for (int i = 2; i <= size * size; i++) {
            
            int nextRow = currentRow - 1;
            
            if (nextRow < 0) {
                nextRow = square.getHeight() - 1;
            }
            int nextColumn = currentColumn + 1;
            
            if (nextColumn >= square.getWidth()) {
                nextColumn = 0;
            }
            
            int nextBoxValue = square.readValue(nextColumn, nextRow);
            if(nextBoxValue != 0){
                nextRow = currentRow + 1;
                nextColumn = currentColumn;
            }
            square.placeValue(nextColumn, nextRow, i);
            currentRow = nextRow;
            currentColumn = nextColumn;
        }
        return square;
    }

}
