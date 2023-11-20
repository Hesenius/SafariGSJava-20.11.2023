package verify;

record X(int a, String b) {}
public class Verify {
  public static void main(String[] args) {
    Object obj = new X(21, "Hello Java %d World!");
    switch (obj) {
      case X(int c, String s) -> System.out.printf(s, c);
      default -> System.out.println("Whatever!");
    }
  }
}
