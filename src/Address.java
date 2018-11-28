import java.util.Comparator;

public class Address implements Comparator<Address> {
  private String name;
  private String lastName;
  private String street;
  private String csz;

  Address(String name, String street, String csz) {
    this.name = name;
    this.street = street;
    this.csz = csz;
    String[] names = name.split(" ");
    this.lastName = names[names.length - 1];
  }

  Address() {}

  String getAddress() {
    return String.format("%s\n%s\n%s", this.name, this.street, this.csz);
  }

  @Override
  public int compare(Address o1, Address o2) {
    return o1.lastName.compareTo(o2.lastName);
  }
}