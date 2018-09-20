import java.util.Scanner;

public class Count {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Count from ");
    int start = s.nextInt();
    
    System.out.print("To ");
    int end = s.nextInt();

    System.out.print("By ");
    int by = s.nextInt();

    s.close();

    for (int i = start; i < end; i += by) {
      System.out.println(i);
    }
  }
}
