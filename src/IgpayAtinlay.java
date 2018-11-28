import java.util.Scanner;

public class IgpayAtinlay {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Utils.log("Please enter a word to pig-latinize: ", false);
    String word = scanner.nextLine();
    scanner.close();
    String vowels = "aeiouy";
    int firstVowel = -1;
    int index = 0;
    while (firstVowel == -1) {
      if (vowels.indexOf(word.substring(index, index + 1)) != -1) {
        firstVowel = index;
      }
      if (index > word.length()) {
        firstVowel = -2;
      }
      index++;
    }
    Utils.log("");
    if (firstVowel == -2) {
      Utils.log("That's not a word!");
    }
    else if (firstVowel == 0) {
      Utils.log(word + " : " + word + "ay");
    }
    else {
      Utils.log(word + " : " + word.substring(firstVowel) + word.substring(0, firstVowel) + "ay");
    }
  }
}
