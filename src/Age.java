import java.util.Random;
import java.util.Scanner;

public class Age {
  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    log("Please tell me your name. ");
    String name = scanner.nextLine();

    log("Thank you, %s.\n", new Object[] {name});

    Thread.sleep(2000);

    log("\nAnd how old might you be, %s? ", new Object[] {name});
    int age = scanner.nextInt();
    scanner.nextLine();

    log("Excellent.", new Object[] {}, 300);

    int rage = random.nextInt(5) + 13;
    Thread.sleep(2000);

    log("\n\nNow, %s, did you say your age was %d? ", new Object[] {name, rage});
    String response = scanner.nextLine();

    if (response.equals("yes")) {
      log("Oh, excellent. I thought so!");
      age = rage;
    }

    if (response.equals("no")) {
      log("Oh, but of course! I know you are %d.", new Object[] {age});
    }

    scanner.close();
  }

  public static void dots(int num, int interval) throws InterruptedException {
    Thread.sleep(interval);
    for (int i = 0; i < num; i++) {
      System.out.print(".");
      Thread.sleep(interval);
    }
  }

  static void log(String line, Object[] replacements, int interval) throws InterruptedException {
    String[] f = String.format(line, replacements).split("");
    for (String character : f) {
      System.out.print(character);
      Thread.sleep(interval);
    }
  }

  static void log(String line, Object[] replacements) throws InterruptedException {
    log(line, replacements, 50);
  }

  static void log(String line) throws InterruptedException {
    log(line, new Object[] {}, 50);
  }
}
