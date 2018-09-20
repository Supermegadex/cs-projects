import java.util.Scanner;

public class Sum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please enter any positive integer: ");
    int num = scanner.nextInt();
    int original = num;
    scanner.close();

    int power = 1;

    while (power < num) {
      power *= 10;
    }

    int sum = 0;

    while (power > 0) {
      int addend = num / power;
      num -= addend * power;
      sum += addend;
      power /= 10;
    }

    System.out.printf(Utils.makeTable(new String[][] {
      {"Number", Integer.toString(original)},
      {"Sum", Integer.toString(sum)}
    }, true));
  }
}