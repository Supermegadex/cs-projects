import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class FullMonty {
  static Random rand = new Random();
  static int[] doors = {0, 0, 0};
  static Scanner scanner = new Scanner(System.in);
  static boolean cont = false;
  static int choice = -1;

  public static void main(String[] args) throws InterruptedException {
    int correctDoor = rand.nextInt(3);
    doors[correctDoor] = 1;

    Utils.ticker("\n\n\n\n\n\nWelcome to... LET'S MAKE A DEAL!");
    Thread.sleep(500);
    Utils.ticker("\nIn front of you, there are three doors. Behind one is a car, and behind the other two are goats.");
    Thread.sleep(500);
    Utils.ticker("\n\nWhich door do you choose? ");

    chooseDoor();

    if (doors[choice] == 0) doors[choice] = 2;

    Utils.ticker("Excellent!");
    Thread.sleep(500);
    Utils.ticker("\nNow, I am going to reveal one of the doors you did not choose.");

    ArrayList<Integer> doorsAvailable = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      if (doors[i] == 0) doorsAvailable.add(i);
    }

    int doorToShow = doorsAvailable.get(rand.nextInt(doorsAvailable.size()));

    Thread.sleep(2000);
    Utils.ticker("\n\nBehind door %s is... ", new String[] {Integer.toString(doorToShow + 1)});
    Thread.sleep(1000);
    Utils.ticker("a goat!");
    Thread.sleep(1000);
    Utils.ticker("\nYou now have a chance to change your choice.");
    Thread.sleep(500);

    Utils.ticker("\n\nWhat is your final decision? ");

    chooseDoor();

    if (choice == correctDoor) {
      Utils.ticker("\nThat's right! You won a new car!");
    }
    else {
      Utils.ticker("\nBehind that door is... a goat!\nYou lose!");
    }
  }

  static void chooseDoor() {
    cont = false;
    while (!cont) {
      try {
        choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < 3) {
          cont = true;
        }
        else {
          Utils.log("Please choose 1, 2, or 3: ", false);
        }
      }
      catch (InputMismatchException err) {
        scanner.next();
        Utils.log("That's not a number. Try again: ", false);
      }
    }
  }
}
