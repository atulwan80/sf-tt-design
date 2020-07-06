package monad;

import java.util.Arrays;

public class UseSuperIterable {
  public static void main(String[] args) {
    SuperIterable<Student> sis = new SuperIterable<>(
        Arrays.asList(
            Student.of("Fred", 3.2, "Math", "Physics"),
            Student.of("Jim", 2.2, "Art"),
            Student.of("Sheila", 3.8,
                "Math", "Physics", "Astrophysics", "Quantum mechanics")
        )
    );

    sis
        .filter(s -> s.getGpa() > 3)
        .map(s -> "Student " + s.getName() + " is smart with grade "
            + s.getGpa())
//        .forEvery(s -> System.out.println(s));
        .forEach(s -> System.out.println(s));

    System.out.println("-----------------------");
    sis.flatMap(s -> new SuperIterable(s.getCourses()))
        .forEach(s -> System.out.println(s));
  }
}
