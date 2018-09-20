import java.util.Scanner;

public class Largest {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Utils.log("Please enter a number: ", false);
    int largest = scanner.nextInt();
    Utils.log("Enter the next one: ", false);
    int num2 = scanner.nextInt();
    if (num2 > largest) largest = num2;
    Utils.log("One more: ", false);
    int num3 = scanner.nextInt();
    if (num3 > largest) largest = num3;
    Utils.log("The largest number is " + largest);
    scanner.close();
  }
}
