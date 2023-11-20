package overloading;

public class Example {
//  public static int add(int a, int b) {
//    System.out.println("adding ints, " + a + " + " + b);
//    return a + b;
//  }

//  public static long add(long a, int b) {
//    System.out.println("adding long and int, " + a + " + " + b);
//    return a + b;
//  }
//
//  public static long add(int a, long b) {
//    System.out.println("adding int and long, " + a + " + " + b);
//    return a + b;
//  }

  public static long add(long a, long b) {
    System.out.println("adding longs, " + a + " + " + b);
    return a + b;
  }

//  GreatCake bakeCake(flour, water, eggs)
//  OKCake bakeCake(packetMixture)

  public static void main(String[] args) {

    System.out.println(add(1L, 2)); // widening promotion 2 -> long
  }
}
