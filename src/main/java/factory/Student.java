package factory;

public class Student {
  private String name;
  private double gpa;

  private Student(String name, double gpa) {
    this.gpa = gpa;
    this.name = name;
  }

  public static Student of(String name, double gpa) {
    if (gpa > 3.7) {
//      return new CleverStudent(); // assignment compatible
    }
    Student self = new Student(name, gpa);
    return self;
  }
}
