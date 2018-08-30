public class Schedule {
  public static void main(String[] args) {
    String[][] classes = {
      {"Block", "Class", "Teacher", "Room"},
      {"1", "World Religions", "Mrs. O'Keefe", "114"},
      {"2", "Chamber Choir", "Mr. Chesire", "Criss"},
      {"3", "AP Physics C", "Mr. Stuva", "112"},
      {"4", "American Government", "Mr. Justice", "101"},
      {"5", "Contemporary Lit", "Mr. Helton", "218"},
      {"6", "Calc III", "Dr. G", "007"},
      {"7", "AP Basket Weaving", "Mr. Thompson", "T-001"},
      {"CP", "CP", "Mrs. Stickels", "210"},
    };

    System.out.print(Utils.makeTable(classes, true));
  }























  public static void original() {
    Class[] classes = {
      new Class("World Religions    ", "Mrs. O'Keefe ", "114  "),
      new Class("Chamber Choir      ", "Mr. Chesire  ", "Criss"),
      new Class("AP Physics C       ", "Mr. Stuva    ", "112  "),
      new Class("American Government", "Mr. Justice  ", "101  "),
      new Class("Contemporary Lit   ", "Mr. Helton   ", "218  "),
      new Class("Calc III           ", "Dr. G        ", "007  "),
      new Class("AP Basket Weaving  ", "Mr. Thompson ", "T-001"),
      new Class("CP                 ", "Mrs. Stickels", "210  "),
    };

    String[] enumeration = {"    1", "    2", "    3", "    4", "    5", "    6", "    7", "   CP"};

    String header = Utils.boxFormat("lhhhhhhhVhhhhhhhhhhhhhhhhhhhhhVhhhhhhhhhhhhhhhVhhhhhhhr\n");
    header += String.format(Utils.boxFormat("v %s v %s               v %s       v %s  v\n"), "Block", "Class", "Teacher", "Room");
    header += Utils.boxFormat(">hhhhhhh+hhhhhhhhhhhhhhhhhhhhh+hhhhhhhhhhhhhhh+hhhhhhh<\n");
    
    System.out.printf(header);

    int num = 0;
    for (Class cls : classes) {
      System.out.printf(cls.toRow(enumeration[num]));
      num++;
    }

    String footer = "Lhhhhhhh^hhhhhhhhhhhhhhhhhhhhh^hhhhhhhhhhhhhhh^hhhhhhhR\n";
    System.out.printf(Utils.boxFormat(footer));
  }
}
