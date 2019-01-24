import java.util.Arrays;
import java.util.Random;

public class Arrayz {
  public static void main(String[] args) {
    Random rando = new Random();
    int[] numbers = new int[10];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rando.nextInt(50);
    }
    Arrays.sort(numbers);
    StringBuilder out = new StringBuilder();
    out.append("Smallest number: ");
    out.append(numbers[0]);
    out.append("\nLargest number: ");
    out.append(numbers[9]);
    Utils.log(out.toString());
  }
}
