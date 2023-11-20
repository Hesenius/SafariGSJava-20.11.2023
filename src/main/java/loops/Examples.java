package loops;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Examples {
//  public static void showAll(List al) {
  public static void showAll(List<String> al) {
    System.out.println("contents:");
//    for (Object obj : al) {
    for (String obj : al) {
      System.out.println(">> " + obj);
    }
    System.out.println("--------------------");
  }
  public static void main(String[] args) {
    int x = 3;
    while (x > 0) {
      System.out.println("x is " + x);
//      x = x - 1;
      x -= 1;
//      System.out.println("x is " + --x); // x++ x-- ++x --x
//      System.out.println("x is " + x--); // x++ x-- ++x --x
    }

    for (int y = 0; y < 3; y++) {
      System.out.println("y is " + y);
    }

    // Arrays: ugly/cumbersome in Java (but more efficient)
    // length is fixed after creation!!
    // subscripts are always monotonic int values starting at zero
    String [] names = new String[3];
    System.out.println("names has  " + names.length + " elements");
    System.out.println("names is " + Arrays.toString(names));
    names[0] = "Fred";
    names[1] = "Jim";
    System.out.println("names[0] is " + names[0]);
    System.out.println("names is " + Arrays.toString(names));

//    int [] ia = new int[3];
//    int [] ia = new int[]{1, 3, 5, 7, 9};
    int [] ia = {1, 3, 5, 7, 9};
    System.out.println("ia is " + Arrays.toString(ia));

    for (String n : names) {
      System.out.println("> " + n);
    }

    // program to the generalization / interface early
    List<String> moreNames = new ArrayList();
//    LinkedList moreNames = new LinkedList();
    moreNames.add("Alice");
    moreNames.add("Bob");
    String name1 = /*(String)*/moreNames.get(0);
//    moreNames.add(LocalDate.now());
    System.out.println("size: " + moreNames.size());
    System.out.println("moreNames is " + moreNames);
    showAll(moreNames);
  }
}
