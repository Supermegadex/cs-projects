public class Variables {
  public static void main(String[] args) {
    String name = "Daniel";
    String age = "17 going on 18";
    String[] cats = {
      "TJ",
      "Jasper",
      "Draco"
    };
    int eyeCount = 6;
    String eyeColor = "blue";
    String hairColor = "blonde";
    double favoriteNumber = Math.exp(1);
    System.out.println("My name is " + name);
    System.out.println("I am " + age);
    System.out.println("I have three cats: " + String.join(", ", cats));
    System.out.println("I have " + eyeCount + " " + eyeColor + " eyes.");
    System.out.println("I have " + hairColor + " hair.");
    System.out.println("My favorite number is " + favoriteNumber);

  }
}