import java.util.Scanner;

public class TTT {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TicTacToe tt = new TicTacToe();
    int turn = 1;
    tt.printBoard(true);

    while (tt.checkWin() == 0) {
      Utils.log("Player " + turn + ":");
      while (!scanner.hasNextInt()) {
        System.out.println("int, please!");
        scanner.nextLine();
      }
      int coords = scanner.nextInt();
      int y = coords / 10 - 1;
      int x = coords % 10 - 1;
      int loc = y * 3 + x;
      if (!tt.spaceFilled(loc)) {
        tt.setItem(turn, loc);
        tt.printBoard(true);
        turn = turn == 1 ? 2 : 1;
      } else {
        Utils.log("That space is already taken!");
      }
    }
    int winner = tt.checkWin();
    if (winner < 3)
      Utils.log("Player " + winner + " wins!");
    else
      Utils.log("The cat stole the game!");
  }
}
