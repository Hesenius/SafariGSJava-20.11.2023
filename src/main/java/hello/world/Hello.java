package hello.world;

// from <project>/src/main/java
// compile:
//  javac -d classes hello/world/*.java
// run:
//  java -cp classes hello.world.Hello

//import java.lang.System;
//import java.lang.*; // all of java.lang is implicitly imported

import java.util.Arrays;
import static java.lang.System.out;

public class Hello {
  public static void main(/*java.lang.*/String[] args) {
//    java.lang.System.out.println("Hello Java World!");
//      System.out.println("Hello Java World!");
      out.println("Hello Java World!");
      out.println(args);
      out.println(Arrays.toString(args));

      // 8 primitive types: boolean* byte short char* int* long* float double*

//    int x;
    int x = 99;
    out.println(x);
    if (x != 0) {} // must have boolean condition, no "truthy/falsy"
//    short s = x;
    short s = (short)x; // might lose value, be careful with casts

    // type of arithmetic results is the larger of the two operands (at least int!!!)
    // + - * / % -- % is remainder, NOT MOD
    // comparisons < > <= >= != ==
    // logical operators && -- and || -- or -- "short circuit"
    // bitwise too & | ^ -- xor ~ -- negate

    int y = 99;
    out.println(x == y);

//    String s1 = new String("Hello");
//    String s2 = new String("Hello");

    // String is immutable -- during compilation, and classloading
    String s1 = "Hello";
    String s2 = "Hello";
    out.println("compare with == " + (s1 == s2));

    out.println("compare with .equals() " + s1.equals(s2));

    String s3 = s1.toLowerCase();
//    s1 = s1.toLowerCase();
    out.println("s1 is now " + s1);
    out.println("s3 is now " + s3);

    String s4 = "Hello World!";
    String s5 = s1 + " World!";
    out.println("s4 is " + s4);
    out.println("s5 is " + s5);
    out.println("s4 == s5 " + (s4 == s5));
    out.println("s4.equals(s5) " + s4.equals(s5));
    s5 = s5.intern();
    out.println("s4 == s5 " + (s4 == s5));
    out.println("s4.equals(s5) " + s4.equals(s5));

    // avoid StringBuffer, it's old, and not as efficient
    StringBuilder sb1 = new StringBuilder("I'm a StringBuilder");
    StringBuilder sb2 = new StringBuilder("I'm");

    sb2.append(" a StringBuilder");
    out.println("sb1 is " + sb1);
    out.println("sb2 is " + sb2);
    out.println("sb1 == sb2 " + (sb1 == sb2));
    out.println("sb1.equals(sb2) " + sb1.equals(sb2));
  }
}
