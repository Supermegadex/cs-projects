import java.util.Scanner;

public class Vowels {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Utils.log("Input at least ten characters: ", false);
    String input = CompareStrings.getString();
    scanner.close();

    String[] vowels = {"a", "e", "i", "o", "u"};
    int[] count = {0, 0, 0, 0, 0};

    for (int vowel = 0; vowel < 5; vowel++) {
      int lastIndex = 0;
      boolean done = false;
      while (!done) {
        int index = input.indexOf(vowels[vowel], lastIndex);
        if (index > -1) {
          count[vowel]++;
          lastIndex = index + 1;
        }
        else {
          done = true;
        }
      }
    }

    String[] values = new String[5];

    for (int i = 0; i < 5; i++) values[i] = String.valueOf(count[i]);

    Utils.log(Utils.makeTable(new String[][] {
      vowels,
      values
    }, true));
  }
}
