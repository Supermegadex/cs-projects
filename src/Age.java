import java.util.Scanner;

public class Age {
  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please tell me your name. ");
    String name = scanner.nextLine();

    System.out.printf("Thank you, %s.\n", name);

    Thread.sleep(3000);

    System.out.print("Just a moment");

    dots(5, 500);

    Thread.sleep(1500);

    System.out.printf("\nAnd how old might you be,%s? ", name);
    int age = scanner.nextInt();

    scanner.close();
  }

  public static void dots(int num, int interval) throws InterruptedException {
    Thread.sleep(interval);
    for (int i = 0; i < num; i++) {
      System.out.print(".");
      Thread.sleep(interval);
    }
  }
}
