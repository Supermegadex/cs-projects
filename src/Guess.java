import java.util.Random;
import java.util.Scanner;

public class Guess {
  public static void main(String[] args) {
    Utils.log("GUESS MY NUMBER!");
    Utils.log("----------------\n");

    Random random = new Random();
    int myNum = random.nextInt(10);
    boolean beEvil = random.nextInt(6) == 2 ? true : false;

    Scanner scanner = new Scanner(System.in);
    Utils.log("Enter your first guess [0-9]: ", false);
    int guess = scanner.nextInt();

    while (guess != myNum) {
      Utils.log("Nope! Try again: ", false);
      guess = scanner.nextInt();
      if (beEvil) myNum = random.nextInt(10);
    }

    scanner.close();

    Utils.log("You got it!");

    // System.out.print((new String("Hello, world!"))[0]);
  }
}
