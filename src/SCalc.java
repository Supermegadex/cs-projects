import java.text.DecimalFormat;
import java.util.Scanner;

public class SCalc {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    df = new DecimalFormat("0.###");

    Utils.log("Welcome! Type in a binary math expression.\n");
    boolean done = false;

    while (!done) {
      Utils.log("> ", false);
      String input = scanner.nextLine();
      if (input.equals("")) done = true;
      else Utils.log(": " + parse(input) + "\n");
    }

    Utils.log("Goodbye!");
    scanner.close();
  }

  private static DecimalFormat df;

  private static String parse(String expression) {
    if (expression.contains("+")) {
      String[] args = expression.split("\\+");
      return add(args);
    }
    if (expression.contains("-")) {
      String[] args = expression.split("\\-");
      return subtract(args);
    }
    if (expression.contains("*")) {
      String[] args = expression.split("\\*");
      return multiply(args);
    }
    if (expression.contains("/")) {
      String[] args = expression.split("\\/");
      return divide(args);
    }
    if (expression.contains("^")) {
      String[] args = expression.split("\\^");
      return pow(args);
    }
    return "Whoa, there!";
  }

  private static String add(String[] args) {
    try {
      return df.format(Double.parseDouble(args[0]) + Double.parseDouble(args[1]));
    }
    catch (NumberFormatException e) {
      return "Whoops!";
    }
  }

  private static String subtract(String[] args) {
    try {
      return df.format(Double.parseDouble(args[0]) - Double.parseDouble(args[1]));
    }
    catch (NumberFormatException e) {
      return "Whoops!";
    }
  }

  private static String multiply(String[] args) {
    try {
      return df.format(Double.parseDouble(args[0]) * Double.parseDouble(args[1]));
    }
    catch (NumberFormatException e) {
      return "Whoops!";
    }
  }

  private static String divide(String[] args) {
    try {
      double a = Double.parseDouble(args[0]);
      double b = Double.parseDouble(args[1]);
      double i = a / b;
      int r = (int)Double.parseDouble(args[0]) % (int)Double.parseDouble(args[1]);
      String result = df.format((int)i);
      if (r > 0) result += "R" + r;
      return result;
    }
    catch (NumberFormatException e) {
      return "Whoops!";
    }
  }

  private static String pow(String[] args) {
    try {
      return df.format(Math.pow(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
    }
    catch (NumberFormatException e) {
      return "Whoops!";
    }
  }
}
