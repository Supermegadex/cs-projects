import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("How many terms? ");
    int terms = scanner.nextInt();
    scanner.close();

    BigInteger a = new BigInteger("0");
    BigInteger b = new BigInteger("1");
    if (terms == 1) {
      System.out.print(a);
      return;
    }
    if (terms == 0) {
      return;
    }
    System.out.print(a + " " + b + " ");
    for (int term = 3; term <= terms; term++) {
      BigInteger next = a.add(b);
      System.out.print(next + " ");
      a = b;
      b = next;
      if (term % 5 == 0) System.out.print("\n");
    }
  }
}
