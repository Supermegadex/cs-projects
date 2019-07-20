import java.util.Arrays;
import java.util.Random;

public class BiglyRows {
  public static void main(String[] args) {
    Random rando = new Random();
    Integer[][] matrix = new Integer[5][5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        matrix[i][j] = rando.nextInt(1000000);
      }
    }

    String[][] table = new String[7][7];
    int[] biggestColumns = new int[5];
    Arrays.fill(biggestColumns, 0);

    for (int i = 0; i < 5; i++) {
      int biggestInRow = 0;
      for (int j = 0; j < 5; j++) {
        if (matrix[i][j] > biggestInRow) {
          biggestInRow = matrix[i][j];
        }
        if (matrix[i][j] > biggestColumns[j]) {
          biggestColumns[j] = matrix[i][j];
        }
        table[i][j] = matrix[i][j].toString();
      }
      table[i][5] = "*vDivider*";
      table[i][6] = Integer.toString(biggestInRow);
    }

    table[5] = new String[7];
    Arrays.fill(table[5], "*hDivider*");
    table[5][5] = "*jDivider*";
    for (int i = 0; i < 5; i++) {
      table[6][i] = Integer.toString(biggestColumns[i]);
    }
    table[6][5] = "*vDivider*";
    int max = 0;
    for (int num: biggestColumns) {
      if (num > max) {
        max = num;
      }
    }
    table[6][6] = Integer.toString(max);

    Utils.log(Utils.makeTable(table, false));
  }
}
