import java.text.DecimalFormat;
import java.util.Scanner;

public class Pythagoras {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String triangle = "" +
    "  v\\\n"+
    "  v \\ c\n"+
    "a v  \\\n"+
    "  v   \\\n"+
    "  Lhhhh\n" + 
    "    b    ";
    Utils.log(Utils.boxFormat(triangle));
    Utils.log("Please enter the side lengths of the two sides you know. Enter '?' for the side you don't.");

    Utils.log("Side a: ", false);
    String a = scanner.nextLine();

    Utils.log("Side b: ", false);
    String b = scanner.nextLine();

    Utils.log("Side c: ", false);
    String c = scanner.nextLine();

    scanner.close();

    String[] sides = calculate(a, b, c);

    String table = Utils.makeTable(new String[][] {
      {"Leg 1", "Leg 2", "Hypotenuse"},
      sides
    }, true);

    Utils.log(table);
  }

  public static int find = -1;

  public static String[] calculate(String a, String b, String c) {
    DecimalFormat df = new DecimalFormat(".00");

    double leg1 = parseSide(a, 0);
    double leg2 = parseSide(b, 1);
    double hypotenuse = parseSide(c, 2);

    if (find == 0) leg1 = calcLeg(leg2, hypotenuse);
    if (find == 1) leg2 = calcLeg(leg1, hypotenuse);
    if (find == 2) hypotenuse = calcHypotenuse(leg1, leg2);

    return new String[] {df.format(leg1), df.format(leg2), df.format(hypotenuse)};
  }

  public static double calcLeg(double leg, double hypotenuse) {
    return Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(leg, 2));
  }

  public static double calcHypotenuse(double leg1, double leg2) {
    return Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2));
  }  

  public static double parseSide(String side, int part) {
    if (side.equals("?")) {
      find = part;
      return -1;
    }
    else {
      return Double.parseDouble(side);
    }
  }
}
