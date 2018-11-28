public class Vowels {
  public static void main(String[] args) {
    Utils.log("Input at least ten characters: ", false);
    String input = CompareStrings.getString().toLowerCase();
    String[] vowels = {"a", "e", "i", "o", "u"}, values = new String[5];
    int[] count = {0, 0, 0, 0, 0};
    for (int vowel = 0; vowel < 5; vowel++) for (int j = 0; j < input.length(); j++) if (input.indexOf(vowels[vowel], j) == j) count[vowel]++;
    for (int i = 0; i < 5; i++) values[i] = String.valueOf(count[i]);
    Utils.log(Utils.makeTable(new String[][] {vowels, values}, true));
  }
}
