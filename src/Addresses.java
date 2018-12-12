import java.io.*;
import java.util.ArrayList;

public class Addresses {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
      new FileReader("C:\\Users\\delpi\\Documents\\cs\\hello-world\\in\\22c_addresses.txt")
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

    addresses.sort(new Address());

    for (Address address : addresses) {
      Utils.log(address.getAddress() + "\n");
    }

    reader.close();
  }
}
