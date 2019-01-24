import java.util.Arrays;
import java.util.Scanner;

/*
# Cell Types
0: water
1: boat
2: miss
3: hit

# State
0: only show hits and misses
1: show everything
 */

class BattleshipState {
  int[][] p1Board = new int[10][10];
  int[][] p2Board = new int[10][10];

  BattleshipState() {
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        p1Board[y][x] = 0;
        p2Board[y][x] = 0;
      }
    }
  }

  int totalHits(int player) {
    int[][] board = getRawBoard(player);
    int total = 0;
    for (int[] row: board) {
      for (int col: row) {
        if (col == 3) {
          total++;
        }
      }
    }
    return total;
  }

  int fire(int player, int[] coords) {
    int[][] board = player == 1 ? p1Board : p2Board;
    int x = coords[0], y = coords[1];
    if (board[y][x] == 0) {
      board[y][x] = 2;
    }
    if (board[y][x] == 1) {
      board[y][x] = 3;
    }
    return board[y][x];
  }

  String getBoard(int player, int state) {
    return getBoard(player == 1 ? p1Board : p2Board, state);
  }

  String getBoard(int[][] pBoard, int state) {
    StringBuilder board = new StringBuilder();
    board.append("    A B C D E F G H I J\n");
    board.append(Utils.boxFormat("  lhhhhhhhhhhhhhhhhhhhh"));

    int rowIndex = 0;
    for (int[] row: pBoard) {
      board.append("\n" + Utils.boxFormat(rowIndex + " v"));
      rowIndex++;
      for (int cell: row) {
        if (state == 0) {
          if (cell == 0 || cell == 1) {
            board.append(" -");
          }
        }
        if (state == 1) {
          if (cell == 0) {
            board.append(" -");
          }
          if (cell == 1) {
            board.append(" #");
          }
        }
        if (cell == 2) {
          board.append(" O");
        }
        if (cell == 3) {
          board.append(" X");
        }
      }
    }

    return board.toString();
  }

  int[][] getRawBoard(int player) {
    int[][] board = player == 1 ? p1Board : p2Board;
    int[][] clone = new int[10][10];
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x < 10; x++) {
        clone[y][x] = board[y][x];
      }
    }
    return clone;
  }

  void setP1Board(int[][] p1Board) {
    this.p1Board = p1Board;
  }

  void setP2Board(int[][] p2Board) {
    this.p2Board = p2Board;
  }

  void setBoard(int player, int[][] board) {
    if (player == 1) {
      setP1Board(board);
    } else {
      setP2Board(board);
    }
  }
}

public class Battleship {
  static BattleshipState state = new BattleshipState();
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    Utils.log("Arrgh! Welcome to battleship, mateys! First, you'll need to place ye ships!");
    Utils.log("To do so, use the WASD keys to move your ship around. Press enter to make the move.");
    Utils.log("Use the ARRR key to change between horizontal and vertical positioning!");
    Utils.log("There are two ships, one is four spaces, the other is three.");
    Utils.log("When yer done with a ship, type \"done!\"\nPress enter now to get started.", false);
    scanner.nextLine();
    Utils.log("\n\n\n\n\n\n\n\n\nPlayer 1, place your ship!");
    placeShip(1, 4);
    Utils.log("\n\n\n\n\n\n\n\n\nGreat job! Now for the second one.");
    placeShip(1, 3);
    Utils.log("\n\n\n\n\n\n\n\n\n\n\nWell done, player one! It's yer turn, player 2!");
    placeShip(2, 4);
    Utils.log("\n\n\n\n\n\n\n\n\nGreat job! Now for the second one.");
    placeShip(2, 3);
    Utils.log("Alrighty, excellent job, mateys! When you're ready, we'll get started.");
    scanner.nextLine();
    startLoop();
  }

  static void startLoop() {
    int winner = 0;
    Utils.log("\n\n\n\n\n\n\n\nGuess where the other player's ships are!");
    Utils.log("Type in coordinates like A1 or H4.");
    while (true) {
      Utils.log("Press enter when Player 1 is ready.");
      scanner.nextLine();
      Utils.log("\n\n\n\n");
      Utils.log(state.getBoard(2, 0));
      Utils.log("Player 1, enter your guess: ", false);
      int[] choice = validateInput();
      int result = state.fire(2, choice);
      Utils.log("\n\n");
      Utils.log(state.getBoard(2, 0));
      printResult(result);
      if (state.totalHits(2) == 7) {
        winner = 1;
        Utils.log("\nYou won!");
        break;
      }
      Utils.log("\n\nPress enter when Player 2 is ready.");
      scanner.nextLine();
      Utils.log("\n\n\n\n");
      Utils.log(state.getBoard(1, 0));
      Utils.log("Player 2, enter your guess: ", false);
      choice = validateInput();
      result = state.fire(1, choice);
      Utils.log("\n\n");
      Utils.log(state.getBoard(1, 0));
      printResult(result);
      if (state.totalHits(1) == 7) {
        winner = 2;
        Utils.log("\nYou won!");
        break;
      }
    }
    Utils.log("Congratulations!");
  }

  static void printResult(int result) {
    if (result == 2) {
      Utils.log("You missed! Shucks!");
    }
    if (result == 3) {
      Utils.log("You hit! Yarrgh!!");
    }
  }

  static int[] validateInput() {
    boolean valid = false;
    String letters = "abcdefghij";
    int[] coords = {0, 0};
    while (!valid) {
      String[] input = scanner.nextLine().split("");
      boolean fail = false;

      try {
        if (input.length > 1) {
          coords[1] = Integer.parseInt(input[1]);
        }
      }
      catch (NumberFormatException e) {
        Utils.log("Format incorrect. Second character must be an integer.");
        fail = true;
      }

      if (input.length != 2) {
        Utils.log("Format incorrect. Use LETTERnumber (i.e. A3).");
        fail = true;
      }
      if (!letters.contains(input[0].toLowerCase())) {
        Utils.log("Format incorrect. First character must be a letter between A and J.");
        fail = true;
      }
      else {
        coords[0] = letters.indexOf(input[0].toLowerCase());
      }
      if (coords[1] > 9 || coords[1] < 0) {
        Utils.log("Second coordinate must be between 0 and 9, inclusive");
        fail = true;
      }
      if (!fail) {
        valid = true;
      }
    }
    return coords;
  }

  static void placeShip(int player, int length) {
    int dir = 0;
    int x = 0;
    int y = 0;
    boolean done = false;
    while (!done) {
      int[][] board = state.getRawBoard(player);
      boolean overlapping = setShipOnBoard(board, x, y, dir, length);
      String bOut = state.getBoard(board, 1);
      Utils.log(bOut);
      String input = scanner.nextLine();
      if (input.equals("done") || input.equals("done!")) {
        if (!overlapping) {
          state.setBoard(player, board);
          done = true;
        }
        else {
          Utils.log("Ships may not overlap.");
        }
      }
      if (input.equals("w") && y > 0) {
        y--;
      }
      if (input.equals("s") && y < 9) {
        y++;
      }
      if (input.equals("a") && x > 0) {
        x--;
      }
      if (input.equals("d") && x < 9) {
        x++;
      }
      if (input.equals("r")) {
        dir = dir == 1 ? 0 : 1;
      }
      if (x + length > 10 && dir == 0) {
        x = 10 - length;
      }
      if (y + length > 10 && dir == 1) {
        y = 10 - length;
      }
    }
  }

  static boolean setShipOnBoard(int[][] board, int x, int y, int dir, int length) {
    boolean isOverlapping = false;
    if (dir == 0) {
      for (int col = x; col < length + x; col++) {
        if (board[y][col] == 1) isOverlapping = true;
        board[y][col] = 1;
      }
    }
    else {
      for (int row = y; row < length + y; row++) {
        if (board[row][x] == 1) isOverlapping = true;
        board[row][x] = 1;
      }
    }
    return isOverlapping;
  }
}
