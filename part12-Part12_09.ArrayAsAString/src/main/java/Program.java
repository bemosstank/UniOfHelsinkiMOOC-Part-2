
public class Program {

    public static void main(String[] args) {
        int row = 2;
        int column = 3;
        int matrix[][] = new int[row][column];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                int value = array[row][column];
                result.append(value);
            }
            result.append("\n");
        }
        return result.toString();
    }
}
