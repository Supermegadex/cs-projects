import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangMe {
  static String[] picture = {
          "         v", // 0
          "    lhhhhr", // 1
          "    o    v", // 2
          "    |    v", // 3
          "   /|    v", // 4
          "   /|\\   v", // 5
          "   /     v", // 6
          "   / \\   v", // 7
          "        h^h" // 8
  };

  static int[][] mans = {
          {1,0,0,0,0},
          {1,2,0,0,0},
          {1,2,3,0,0},
          {1,2,4,0,0},
          {1,2,5,0,0},
          {1,2,5,3,0},
          {1,2,5,3,6},
          {1,2,5,3,7}
  };

  static String assemble(int[] indices) {
    StringBuilder str = new StringBuilder();
    for (int index: indices) {
      str.append(picture[index] + "\n");
    }
    str.append(picture[8]);
    return Utils.boxFormat(str.toString());
  }

  static String blanks(String word, ArrayList<Integer> correct) {
    String[] blanks = new String[word.length()];
    Arrays.fill(blanks, "_");
    for (int idx: correct) {
      blanks[idx] = word.substring(idx, idx + 1);
    }
    return String.join(" ", blanks);
  }

  static boolean guess(String word, String guess, ArrayList<Integer> correct) {
    boolean success = false;
    for (int i = 0; i < word.length(); i++) {
      if (word.substring(i, i + 1).equals(guess)) {
        if (!correct.contains(i)) {
          correct.add(i);
        }
        success = true;
      }
    }
    return success;
  }

  public static void main(String[] args) throws IOException {
    Random rando = new Random();
    BufferedReader reader = new BufferedReader(
      new FileReader("C:\\Users\\delpi\\code\\cs-projects\\in\\words.txt")
    );

    int wordIdx = rando.nextInt(1255);
    String word = "what";

    for (int i = 0; i < wordIdx; i++) {
      word = reader.readLine();
    }

    ArrayList<Integer> correct = new ArrayList<>();

    reader.close();

    ArrayList<String> fails = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    boolean done = false;
    while (!done) {
      Utils.log(assemble(mans[fails.size()]));
      Utils.log(blanks(word, correct));
      Utils.log("Incorrect: " + String.join(", ", fails));
      Utils.log("Your guess: ");
      String guess = scanner.nextLine();
      boolean success = guess(word, guess, correct);
      if (!success && !fails.contains(guess)) fails.add(guess);
      if (fails.size() >= 8) {
        Utils.log("You lose! The correct word was " + word + ".");
        return;
      }
      if (!blanks(word, correct).contains("_")) {
        Utils.log("You win! The word is " + word + "!");
        done = true;
      }
    }
  }
}
