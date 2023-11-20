package school;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class SmartStudent implements Predicate<Student> {
  @Override
  public boolean test(Student student) {
    return student.grade() > 70;
  }
}

public class School {
  public static void showAll(List<Student> ls) {
    System.out.println("students:");
    for (Student s : ls) {
      System.out.println("-- " + s);
    }
  }

  // define EXACLY ONE abstract method
//  interface Predicate<E> {
//    boolean test(E e);
//  }
public static List<Student> getSmart(List<Student> ls, Predicate<Student> ps) {
  List<Student> res = new ArrayList<>();
  for (Student s : ls) {
    if (ps.test(s)) { // method takes Student, returns boolean
      res.add(s);
    }
  }
  return res;
}

//  public static List<Student> getSmart(List<Student> ls, int threshold) {
////    List<Student> res = new ArrayList<Student>();
//    List<Student> res = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.grade() > threshold) { // method takes Student, returns boolean
//        res.add(s);
//      }
//    }
//    return res;
//  }
  public static void main(String[] args) {
    List<Student> students = List.of(
      new Student("Fred", 76, "Math", "Physics"),
      new Student("Jim", 56, "Journalism"),
      new Student("Sheila", 96, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );

    System.out.println(students);

    // print all the smart students
    showAll(students);
//    System.out.println("Smart:");
//    showAll(getSmart(students, 60));
//    System.out.println("Very Smart:");
//    showAll(getSmart(students, 80));
    System.out.println("Smart:");
    showAll(getSmart(students, new SmartStudent()));
    System.out.println("Very Smart:");
    showAll(getSmart(students,
//      (Student student) -> { return student.grade() > 70; }
//      since java 10 var can be used for placeholder for type allowing annotation
//      (@annotation var student) -> { return student.grade() > 70; }
//      (a, b, c) -> {...}
//      () -> {...}
//      student -> { return student.grade() > 70; }
      student -> student.grade() > 70
    ));

    // Stream api "monad-like" big(ish) data processing (not distributed like Spark)
    // lazy, and parallelizable, map, flatMap, filter, forEach, and more

    students
      .stream()
      .filter(s -> s.courses().length > 2)
      .map(s -> "Student named " + s.name() + " takes " + s.courses().length +
        " courses")
      .forEach(s -> System.out.println(s));
  }
}
