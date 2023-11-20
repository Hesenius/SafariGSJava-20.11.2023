package school;

import java.util.Arrays;

// implicitly "final" class -- final class cannot have subtypes
public record Student(String name, int grade, String ... courses) {
  @Override
  public String toString() {
    return "Student, name=" + name + " grade=" + grade +
      " courses=" + Arrays.toString(courses);
  }
}
