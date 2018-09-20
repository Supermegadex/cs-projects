import java.text.DecimalFormat;
import java.util.Scanner;

public class MS {
  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("##0.00");
    String[][] table = new String[32][2];
    table[0] = new String[] {"x", "y"};

    int i = 1;
    for (double x = -5; x <= 10; x += .5) {
      String[] row = {
        df.format(x), df.format(f(x)) + (f(x) % 2 == 0 && x > 0 ? "**" : "")
      };
      table[i] = row;
      i++;
    }

    System.out.print(Utils.makeTable(table, true));
  }

  static double f(double x) {
    return x * x;
  }
}

class Row {
  Row(double x, double y) {

  }
}
