package monad;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student {
  private String name;
  private double gpa;
  private List<String> courses;

  private Student(String name, double gpa, List<String> courses) {
    this.name = name;
    this.gpa = gpa;
    this.courses = courses;
  }

  public static Student of(String name, double gpa, String ... courses) {
    Student self = new Student(name, gpa, Arrays.asList(courses));
    return self;
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  public List<String> getCourses() {
    return Collections.unmodifiableList(courses);
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        ", courses=" + courses +
        '}';
  }
}
