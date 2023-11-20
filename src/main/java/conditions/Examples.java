package conditions;

public class Examples {
  public static void main(String[] args) {
    int x = 99;
    if (x > 100) { // parens required, expression must be boolean (or Boolean)
      System.out.println("biggest");
    } else if (x > 50) {
      System.out.println("bigger");
    } else {
      System.out.println("smaller");
    }

    // pre Java 17 example
    // Must be int or smaller numeric type, or String, or an enum
    switch (x) {
      case 98:
      case 99:
      case 100:
        System.out.println("about 99");
        break;
      default:
        System.out.println("not about 99");
        break;
    }

    // Newer Java (17+)
    switch (x) {
      // arrow form does not fall through
      case 98, 99, 100 -> { // need curlies for multiple statements
        System.out.println("about 99");
        System.out.println("it's actually " + x);
      }
      default -> System.out.println("something else");
    }

    // also newer Java "expression forms" (can do with colon, but why?)
    String msg = switch (x) {
      case 98, 99, 100 -> "It's about 99";
      default -> "Something else"; // switch expression must cover all input cases
    };
    System.out.println("Message is " + msg);
  }
}
