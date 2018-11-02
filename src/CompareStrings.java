import java.util.Scanner;

public class CompareStrings {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] argss) {
    Utils.log("Gib strang of ten plus chars: ", false);
    String str1 = getString();
    Utils.log("Gib nother: ", false);
    String str2 = getString();

    if (str1.equals(str2)) Utils.log("\nThey definitely the same.");
    else Utils.log("\nThey not the same at all");
  }

  public static String getString() {
    String value = "";
    boolean success = false;
    while (!success) {
      String next = scanner.nextLine();
      if (next.length() >= 10) {
        value = next;
        success = true;
      }
      else {
        Utils.log("Whoops. We need ten plus: ", false);
      }
    }
    return value;
  }
}
