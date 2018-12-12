import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sales {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    BufferedReader reader = new BufferedReader(
      new FileReader("C:\\Users\\delpi\\Documents\\cs\\hello-world\\in\\22c_sales.txt")
    );

    ArrayList<String> cups = new ArrayList<>();
    int numCups = 0;

    boolean done = false;
    while (!done) {
      String cup = reader.readLine();
      if (cup != null) {
        cups.add(cup);
        numCups += Integer.parseInt(cup);
      }
      else done = true;
    }

    Utils.log(cups.remove(0), false);
    for (String cup : cups) {
      Utils.log(" + " + cup, false);
    }
    Utils.log(String.format(" = %d cups!", numCups));

    reader.close();
  }
}
