package usingtypes;

// not public so it can be in the same source file
// "default" access
class Car implements Colored { // implicitly a subclass of java.lang.Object
  // if we provide zero coded constructors, we get a "default" constructor
  // that takes no arguments. accessibility is same as the class
  Car() {
    // super() -- initializes the parent parts of this object--must be first
    // IMPLICIT -- instance initialization (field initiations)
    // now our own code
    System.out.println("Creating a Car...");
    carCount++;
  }

  Car(String color, int seats) {
    // implicit super() OR explict super() OR explicit this(...)
    this();
    // implicit instance initialization (If, but only if super() above
    System.out.println("color currently: " + this.color);
    System.out.println("seats currently: " + this.seats);
    this.color = color;
    this.seats = seats;
  }

  // private in Java says "accessible anywhere between the enclosing TOP-LEVEL curlies
  // classes can be declared inside other classes. Everything in the same top-level class
  // shares privileged access to everything else in there (like "friends")
  private String color = "Red";
  private int seats;

  // optional "receiver parameter" 'this' since Java 1.6
//  public String getColor(Car this) {
  public String getColor() {
//    return this.color;
    return color;
  }

  public void setColor(String color) {
    if (color == null) { // validation
      throw new IllegalArgumentException("Bad color, can't be null");
    }
    this.color = color;
  }

  private static int carCount = 0;
  public static int getCarCount() {
//    return Car.carCount;
    return carCount;
  }

  @Override // VERIFY that this IS an override (NOT "make it one")
  public String toString() {
    return "Car " + color + " with " + seats + " seats";
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Car other &&
      this.seats == other.seats &&
      this.color.equals(other.color);
  }
}

class SportsCar extends Car {
  private int topSpeed;
  SportsCar(int topSpeed) {
    // implicit super() OR explicit super :)
    super("Red", 2);
    this.topSpeed = topSpeed;
  }

  @Override
  public String toString() {
    return super.toString() + " a sports car with top speed of " + topSpeed;
  }

  public int getTopSpeed() {
    return this.topSpeed;
  }
}

interface Colored {
  /* implicitly abstract and public */ String getColor();
}

public class ClassExample {
  public static void main(String[] args) {
//    Car c = new Car(); // new allocates and zeroes memory
    Car c = new Car("Green", 7);
//    c.color = "Blue";
//    c.seats = 5;
//    System.out.println("car is " + c); // calls toString
    System.out.println("car is " + c.toString());
    c.setColor("Blue");
    System.out.println("car is " + c);
    System.out.println("color is " + c.getColor());
//    System.out.println("color is " + c.color);
//    Car c2 = new Car();
    Car c2 = new Car("Blue", 7);
    System.out.println("c.equals(c2) " + c.equals(c2));
    System.out.println("c2 color is " + c2.getColor());
    System.out.println("carcount is " + Car.getCarCount());

    // methods you can call are determined by the type of the REFERENCE EXPRESSION
    // behavior you get is determined by the type of the object referred to
    Car sc = new SportsCar(180);
//    sc.getTopSpeed(); NOPE!!! not guaranteed
//    System.out.println(((SportsCar)sc).getTopSpeed());

//    if (sc instanceof SportsCar) { // pre - java 17
//      SportsCar sc2 = (SportsCar) sc;
//      System.out.println(sc2.getTopSpeed());
//    }

    if (sc instanceof SportsCar sc2) { // pattern matching
      System.out.println(sc2.getTopSpeed());
    }
    System.out.println(sc);

    Colored thing = sc;
    System.out.println("Thing's color is " + sc.getColor());
  }
}
