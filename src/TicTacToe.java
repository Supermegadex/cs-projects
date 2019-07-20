import java.util.Arrays;

class TicTacToe {
  int[][] winningBoards = {
          {1, 1, 1, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 1, 1, 1, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 1, 1, 1},
          {1, 0, 0, 1, 0, 0, 1, 0, 0},
          {0, 1, 0, 0, 1, 0, 0, 1, 0},
          {0, 0, 1, 0, 0, 1, 0, 0, 1},
          {1, 0, 0, 0, 1, 0, 0, 0, 1},
          {0, 0, 1, 0, 1, 0, 1, 0, 0}
  };

  private int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};

  String printBoard() {
    StringBuilder builder = new StringBuilder();
    for (int row = 0; row < 3; row++) {
      for (int column = 0; column < 3; column++) {
        builder.append(getChar(row, column));
        if (column < 2) {
          builder.append(Utils.boxFormat("v"));
        }
      }
      builder.append("\n");
      if (row < 2) {
        builder.append(Utils.boxFormat("h+h+h\n"));
      }
    }
    return builder.toString();
  }

  void printBoard(boolean toConsole) {
    Utils.log(printBoard());
  }

  String getChar(int row, int column) {
    int player = board[row * 3 + column];
    switch (player) {
      case 1:
        return "x";
      case 2:
        return "o";
      default:
        return " ";
    }
  }

  int checkWin() {
    int winner = 0;
    if (playerDidWin(1)) winner = 1;
    if (playerDidWin(2)) winner = 2;
    if (playerDidWin(0)) winner = 3;
    return winner;
  }

  boolean playerDidWin(int player) {
    int[] playerBoard = new int[9];
    for (int item = 0; item < 9; item++) {
      if (board[item] == player) playerBoard[item] = 1;
      else playerBoard[item] = 0;
    }
    if (player == 0) {
      return Arrays.equals(playerBoard, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
    }
    else {
      for (int[] winnerBoard: winningBoards) {
        boolean winner = true;
        for (int i = 0; i < 9; i++) {
          if (winnerBoard[i] == 1) {
            if (playerBoard[i] != 1) {
              winner = false;
            }
          }
        }
        if (winner) return true;
      }
    }
    return false;
  }

  void setItem(int player, int loc) {
    board[loc] = player;
  }

  boolean spaceFilled(int loc) {
    return board[loc] > 0;
  }
}
