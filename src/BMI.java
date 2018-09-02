import java.text.DecimalFormat;
import java.util.Scanner;

public class BMI {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Your name: ");
    String name = scanner.next();

    System.out.print("Your height in feet: ");
    double height = scanner.nextDouble();

    System.out.print("Your weight in pounds: ");
    double weight = scanner.nextDouble();

    scanner.close();

    double inches = height * 12.;
    double bmi = (weight / (inches * inches)) * 703.0704;
    
    String classification = "";
    if (bmi < 18.5) classification = "Underweight";
    else if (bmi < 25) classification = "Normal";
    else if (bmi < 30) classification = "Overweight";
    else if (bmi < 40) classification = "Obese";
    else classification = "Extremely Obese";

    DecimalFormat formatter = new DecimalFormat("##.#");

    System.out.println(Utils.makeTable(new String[][] {
      {"Name", "Height", "Weight", "BMI", "Classification"},
      {name, Double.toString(height), Double.toString(weight), formatter.format(bmi), classification}
    }, true));
  }
}