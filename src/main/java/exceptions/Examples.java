package exceptions;

public class Examples {

  public static void doStuff() {
    System.out.println("doing Stuff...");
    if (Math.random() > 0.5) {
      throw new IllegalArgumentException("too big!");
    }
  }

  public static void main(String[] args) {
    try {
      // happy path
      doStuff();
      System.out.println("succeeded, still going");
    } catch (NullPointerException npe) {
      System.out.println("NPE!");
    } catch(IllegalArgumentException ie) {
      System.out.println("uh oh, that broke, message is " + ie. getMessage());
    } catch (RuntimeException re) { // more general (parent) exceptions must come later
      System.out.println("Runtime (general) problem");
    } finally {
      System.out.println("success or failure comes here :) ");
    }
    System.out.println("still going");
  }
}
