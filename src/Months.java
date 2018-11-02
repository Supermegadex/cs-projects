import java.util.Scanner;

public class Months {
  private String[] months = {
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "Septeber",
    "October",
    "November",
    "December"
  };

  public String getMonth(int month) {
    return months[month - 1];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Months mos = new Months();

    Utils.log("Enter a number [1-12]: ", false);
    int mo = scanner.nextInt();
    scanner.close();

    Utils.log("The month name is " + mos.getMonth(mo) + ".");
  }
}