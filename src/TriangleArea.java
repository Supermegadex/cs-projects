import java.text.DecimalFormat;

public class TriangleArea {
  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("0.##");

    double a = Double.parseDouble(args[0]);
    double b = Double.parseDouble(args[1]);
    double c = Double.parseDouble(args[2]);

    double s = (a + b + c) / 2;

    double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

    Utils.log(String.format("Area: %s", df.format(area)));
  }
}
