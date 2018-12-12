public class Test {
  public static void main(String[] args) {
    double biggest = 0;
    double smallest = 100;
    for (int i = 0; i < 20000; i++) {
      double a = Math.random() * 10;
      double b = Math.random() * 5 + 5;

      double c = a + b;
      if (c > biggest) biggest = c;
      if (c < smallest) smallest = c;
    }

    System.out.printf("Biggest: %f\nSmallest: %f", biggest, smallest);
  }
}
