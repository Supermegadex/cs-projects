public class Address {
  public String name;
  public String street;
  public String csz;

  Address(String name, String street, String csz) {
    this.name = name;
    this.street = street;
    this.csz = csz;
  }

  getAddress() {
    return String.format("%s\n%s\n%s", this.name, this.street, this.csz);
  }
}