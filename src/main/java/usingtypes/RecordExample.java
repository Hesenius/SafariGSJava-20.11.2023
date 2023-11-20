package usingtypes;

// Java 17 onwards
record Truck(String color, int payload) { }

public class RecordExample {
  public static void main(String[] args) {
    Truck t1 = new Truck("Black", 10_000);
    Truck t2 = new Truck("Black", 10_000);
    Truck t3 = new Truck("Blue", 10_000);
    System.out.println(t1);
    System.out.println(t1 == t2);
    System.out.println(t1.equals(t2));
  }
}
// override resolution
// enum
// exceptions
// lambdas
