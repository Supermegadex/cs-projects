class Magpie {
  String getGreeting() {
    return "Hello, let's talk.";
  }

  private boolean contains(String[] statement, String[] search) {
    for (String find: search) {
      for (String word: statement) {
        if (find.equals(word)) return true;
      }
    }
    return false;
  }

  private String rest(String[] words, int start, int end) {
    StringBuilder builder = new StringBuilder();
    for (int i = start; i < end; i++) {
      builder.append(words[i] + " ");
    }
    return builder.toString().trim();
  }

  String getResponse(String statement) {
    String response;
    statement = statement.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    String[] words = statement.split(" ");
    if (statement.contains("no")) {
      response = "Why so negative?";
    }
    else if (contains(words, new String[] {
      "mom", "moms", "dad", "dads", "parent", "parents",
      "brother", "brothers", "sister", "sisters",
      "aunt", "aunts", "uncle", "uncles", "cousin", "cousins"
    })) {
      response = "Tell me more about your family.";
    }
    else if (contains(words, new String[] {
      "cat", "cats", "dog", "dogs", "fish", "fishes", "gecko", "geckos",
      "lizard", "lizards", "snake", "snakes", "alligators", "alligator",
      "ferret", "ferrets", "tarantula", "tarantulas", "hamster", "hamsters",
      "gerbil", "gerbils", "mouse", "mice", "rat", "rats"
    })) {
      response = "Tell me more about your pets.";
    }
    else if (contains(words, new String[] {
      "thompson", "eric", "erics", "thompsons"
    })) {
      response = "Tell me more about this cool-sounding guy.";
    }
    else if (contains(words, new String[] {"i"}) && contains(words, new String[] {"like"})) {
      response = "Why do you like " + rest(words, 2, words.length) + "?";
    }
    else if (contains(words, new String[] {"i"}) && contains(words, new String[] {"want"})) {
      response = "Would you like it if you had " + rest(words, 2, words.length) + "?";
    }
    else if (statement.trim().equals("")) {
      response = "Tell me something at least.";
    }
    else {
      response = getRandomResponse();
    }
    return response;
  }

  private String getRandomResponse() {
    final int NUMBER_OF_RESPONSES = 4;
    double r = Math.random();
    int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
    String response = "";

    if (whichResponse == 0) {
      response = "Interesting, tell me more.";
    }
    else if (whichResponse == 1) {
      response = "Hmmm.";
    }
    else if (whichResponse == 2) {
      response = "Do you really think so?";
    }
    else if (whichResponse == 3) {
      response = "You don't say.";
    }

    return response;
  }
}
