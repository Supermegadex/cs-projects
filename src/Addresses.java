import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

public class Addresses {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    BufferedReader reader = new BufferedReader(
      new FileReader("C:\\Users\\delpi\\Documents\\cs\\hello-world\\src\\in\\22c_addresses.txt")
    );

    ArrayList<Address> addresses = new ArrayList<>();

    boolean done = false;
    while (!done) {
      String name = reader.readLine();
      if (name != null) {
        String street = reader.readLine();
        String csz = reader.readLine();
        reader.readLine();
        addresses.add(new Address(name, street, csz));
      }
      else done = true;
    }

    while (addresses.size() > 0) {
      int lastName = 100;
      int index = 0;
      for (Address addr : addresses) {
        String[] name = addr.name.split(" ");
        Utils.log(name[name.length - 1]);
        Utils.log(String.format("%d", Character.getNumericValue(name[name.length - 1].charAt(0))));
        // if (name[name.length - 1].charAt(0) < lastName) {

        // }
      }
      addresses.remove(0);
    }

    reader.close();
  }
}
