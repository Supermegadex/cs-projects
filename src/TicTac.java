import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class BJGame {
  private ArrayList<Integer> p1 = new ArrayList<>();
  private ArrayList<Integer> p2 = new ArrayList<>();
  private Random rand = new Random();

  void dealCards() {
    p1.add(rand.nextInt(14) + 1);
    p2.add(rand.nextInt(14) + 1);
    p2.add(rand.nextInt(14) + 1);
    p1.add(rand.nextInt(14) + 1);
  }

  void hit(int player) {
    ArrayList<Integer> cards;
    if (player == 1) cards = p1;
    else cards = p2;
    cards.add(rand.nextInt(14) + 1);
  }

  String getPlayerCardsString(int player, boolean hide) {
    ArrayList<Integer> cards;
    if (player == 1) cards = p1;
    else cards = p2;
    StringBuilder builder = new StringBuilder();
    int index = 0;
    for (int card: cards) {
      String value = Integer.toString(card);
      if (index == 0 && hide) {
        value = "X";
      }
      else if (card > 10) {
        switch (card) {
          case 11:
            value = "J";
            break;
          case 12:
            value = "Q";
            break;
          case 13:
            value = "K";
            break;
          case 14:
            value = "A";
            break;
          default:
            value = "????????";
            break;
        }
      }
      index++;
      builder.append(value);
      builder.append(" ");
    }
    if (!hide) {
      builder.append(": ")
              .append(this.getPlayerCardsValue(player));
    }
    return builder.toString();
  }

  int getPlayerCardsValue(int player) {
    int total = 0;
    ArrayList<Integer> cards;
    if (player == 1) cards = p1;
    else cards = p2;
    int aces = 0;
    for (int card: cards) {
      if (card == 14){
        card = 11;
        aces++;
      }
      else if (card > 10) card = 10;
      total += card;
    }
    while (total > 21 && aces > 0) {
      total -= 10;
      aces--;
    }
    return total;
  }
}

public class TicTac {
  static Scanner scanner;

  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    Utils.log("Hi. This is BlackJackTicTac™. Start by pressing enter.");
    scanner.nextLine();
    startGame();
  }

  static void startGame() {
    BJGame game = new BJGame();
    game.dealCards();
    takeTurn(game);
  }

  static void takeTurn(BJGame game) {
    Utils.log("Dealer's hand: " + game.getPlayerCardsString(2, true));
    Utils.log("Your hand: " + game.getPlayerCardsString(1, false));
    Utils.log("\nWanna hit or stand? ");
    String choice = waitForEntry("hit", "stand");
    if (choice.toLowerCase().contains("hit")) {
      game.hit(1);
      if (game.getPlayerCardsValue(1) > 21) {
        finish(game);
      }
      else {
        takeTurn(game);
      }
    }
    else if (choice.toLowerCase().contains("stand")) {
      doDealer(game);
    }
  }

  static void doDealer(BJGame game) {
    while (game.getPlayerCardsValue(2) < 16) {
      game.hit(2);
    }
    finish(game);
  }

  static void finish(BJGame game) {
    int player = game.getPlayerCardsValue(1);
    int dealer = game.getPlayerCardsValue(2);
    Utils.log("\nThe game is over!\nHere are the standings");
    Utils.log("Player: " + game.getPlayerCardsString(1, false));
    Utils.log("Dealer: " + game.getPlayerCardsString(2, false));
    if ((player <= 21 && player > dealer) || dealer > 21) {
      Utils.log("\nYou win!");
    }
    else Utils.log("\nYou lose!");
    Utils.log("\n\nWant to play again? ");
    String choice = waitForEntry("y", "n");
    if (choice.toLowerCase().contains("y")) {
      startGame();
    }
  }

  static String waitForEntry(String option1, String option2) {
    while (true) {
      String input = scanner.nextLine();
      if (input.toLowerCase().contains(option1) || input.toLowerCase().contains(option2)) {
        return input;
      }
      else {
        Utils.log("Please enter \"" + option1 + "\" or \"" + option2 + "\" then press enter: ");
      }
    }
  }
}
