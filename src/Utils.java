import java.util.Arrays;

public class Utils {
  static String boxFormat(String str) {
    // Plain borders
    str = str.replace("h", "\u2500");
    str = str.replace("v", "\u2502");
    // Two-junction characters
    str = str.replace("l", "\u250c");
    str = str.replace("r", "\u2510");
    str = str.replace("L", "\u2514");
    str = str.replace("R", "\u2518");
    // Three-junction characters
    str = str.replace("^", "\u2534");
    str = str.replace("V", "\u252c");
    str = str.replace("<", "\u2524");
    str = str.replace(">", "\u251c");
    // Four-junction character
    str = str.replace("+", "\u253c");
    return str;
  }

  static String makeTable(String[][] matrix, boolean hasHeader) {
    // Get the maximum lengths of each column
    int[] lengths = new int[matrix[0].length];
    Arrays.fill(lengths, 1);

    for (String[] row : matrix) {
      for (int i = 0; i < row.length; i++) {
        if (!(row[i].equals("*hDivider*") || row[i].equals("*vDivider*") || row[i].equals("*jDivider*"))) {
          if (row[i].length() + 2 > lengths[i]) {
            lengths[i] = row[i].length() + 2;
          }
        }
      }
    }

    StringBuilder table = new StringBuilder();

    String[] hs = new String[matrix[0].length];
    Arrays.fill(hs, "");
    for (int i = 0; i < hs.length; i++) {
      for (int l = 0; l < lengths[i]; l++) {
        hs[i] += "h";
      }
    }

    int locationOfVerticalBreak = getLocationOfVDivider(matrix[0]);
    int locationOfFinalVerticalBreak = getLocationOfVDivider(matrix[matrix.length - 1]);

    if (!hasHeader) {
      if (locationOfVerticalBreak >= 0) {
        log("wat");
        hs[locationOfVerticalBreak] = "hhhVhhh";
      }
    }
    
    table.append(Utils.boxFormat("l" + String.join("h", hs) + "r\n"));

    // Make the header80
    if (hasHeader) {
      StringBuilder header = new StringBuilder();
      header.append(Utils.makeTableRow(matrix[0], lengths) + "\n");
      header.append(Utils.boxFormat(">" + String.join("h", hs) + "<\n"));
      
      table.append(header.toString());
    }

    for (int row = hasHeader ? 1 : 0; row < matrix.length; row++) {
      table.append(Utils.makeTableRow(matrix[row], lengths) + "\n");
    }

    if (!hasHeader) {
      if (locationOfFinalVerticalBreak >= 0) {
        hs[locationOfFinalVerticalBreak] = "hhh^hhh";
      }
    }

    table.append(Utils.boxFormat("L" + String.join("h", hs) + "R\n"));

    return table.toString();
  }

  private static int getLocationOfVDivider(String[] row) {
    int locationOfVerticalBreak = -1;
    for (int i = 0; i < row.length; i++) {
      if (row[i].equals("*vDivider*")) {
        locationOfVerticalBreak = i;
      }
    }
    return locationOfVerticalBreak;
  }

  private static String makeTableRow(String[] row, int[] lengths) {
    boolean dividerRowLeft = row[0].equals("*hDivider*");
    boolean dividerRowRight = row[row.length - 1].equals("*hDivider*");
    for (int i = 0; i < row.length; i++) {
      if (row[i].equals("*vDivider*")) {
        row[i] = boxFormat("v");
      }
      if (row[i].equals("*hDivider*")) {
        String[] hs = new String [lengths[i] + 1];
        Arrays.fill(hs, "h");
        row[i] = boxFormat(String.join("",hs));
      }
      else if (row[i].equals("*jDivider*")) {
        row[i] = boxFormat("+");
      }
      else {
        int toAdd = lengths[i] - 2 - row[i].length();
        for (int j = 0; j < toAdd; j++) {
          row[i] += " ";
        }
        if (i < row.length - 1) {
          row[i] += "   ";
        }
      }
    }
    String left = boxFormat("v   ");
    String right = boxFormat("   v");
    if (dividerRowLeft) {
      left = boxFormat(">hhh");
    }
    if (dividerRowRight) {
      right = boxFormat("hhh<");
    }
    return left + String.join(boxFormat(""), row) + right;
  }

  static double formatHeight(String height) {
    String[] chars = height.split("");
    StringBuilder feet = new StringBuilder();
    StringBuilder inches = new StringBuilder();
    feet.append("0");
    inches.append("0");
    int part = 0;
    for (String ch: chars) {
      switch (part) {
        case 0:
          if (ch.matches("[0-9]")) {
            feet.append(ch);
          }
          if (ch.matches("'")) {
            part = 1;
          }
          break;
        case 1:
          if (ch.matches("[0-9]")) {
            inches.append(ch);
          }
          break;
        default:
          break;
      }
    }

    return (Double.parseDouble(feet.toString()) * 12) + Double.parseDouble(inches.toString());
  }

  public static void log(String log, boolean ln) {
    if (ln) System.out.println(log);
    else System.out.print(log);
  }

  public static void log(String msg) {
    log(msg, true);
  }

  static void ticker(String line, Object[] replacements, int interval) throws InterruptedException {
    String[] f = String.format(line, replacements).split("");
    for (String character : f) {
      System.out.print(character);
      Thread.sleep(interval);
    }
  }

  static void ticker(String line, Object[] replacements) throws InterruptedException {
    ticker(line, replacements, 50);
  }

  static void ticker(String line) throws InterruptedException {
    ticker(line, new Object[] {}, 50);
  }
}