// import org.fusesource.jansi.AnsiConsole;

public class Main {
  public static void main(String[] args) {

    String[][] t = {
      {"Basket Weaving", "Thompson", "T-001"},
      {"Chamber Band", "Chesire", "Criss"}
    };

    System.out.print(Utils.makeTable(t, false));


    // AnsiConsole.systemInstall();

    // System.out.println("\u001B[31;1mHello\u001B[0m, \u001B[32;1;2mworld!\u001B[0m");
    // String a = Utils.boxFormat("lhhhhhhhhhhhhhhhhhhhhhhhhhhhr\n");
    // String b = Utils.boxFormat("v") + " Why plan when I can \u001B[3mcode\u001B[0m? " + Utils.boxFormat("v\n");
    // String c = Utils.boxFormat("v") + "             - Daniel Noon " + Utils.boxFormat("v\n");
    // String d = Utils.boxFormat("LhhhhhhhhhhhhhhhhhhhhhhhhhhhR\n");
    // System.out.println(a + b + c + d);

    // Variables.main(args);
    // String[] messages = {
    //   "Hello, world! I'm Daniel.",
    //   "",
    //   "I like to program in my free time.",
    //   "I also act in the Marian Musicals and plays.",
    //   "I have three cats: TJ, Jasper, and Draco.",
    //   "Check out my projects at https://github.com/Supermegadex"
    // };

    // for (String message : messages) {
    //   System.out.println(message);
    // }
  }
}
