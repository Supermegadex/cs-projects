import java.text.DecimalFormat;
import java.util.Scanner;

public class Grade {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    DecimalFormat formatter = new DecimalFormat("###.##");

    System.out.print("Enter the points you earned: ");
    double correct = input.nextDouble();

    System.out.print("Enter the points possible: ");
    double possible = input.nextDouble();

    input.close();

    double score = correct / possible * 100.;
    String formattedScore = formatter.format(score);

    String message = "You got a " + formattedScore + "%";

    String hs = "";
    for (int i = 0; i < message.length(); i++) hs += "h";

    System.out.println(Utils.boxFormat("lh" + hs + "hr"));
    System.out.println(Utils.boxFormat("v ") + message + Utils.boxFormat(" v"));
    System.out.println(Utils.boxFormat("Lh" + hs + "hR"));
  }
}
