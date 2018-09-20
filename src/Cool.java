import java.util.Scanner;

public class Cool {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Hey, how cool is Daniel? [0-10] ");
    int cool = s.nextInt();

    s.close();

    for (int i = 0; i < cool; i++) {
      System.out.println("Daniel is cool.");
    }
  }
}
