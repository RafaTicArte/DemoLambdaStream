package DemoLambdaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Variables
        List<String> names = new ArrayList<>(
                Arrays.asList(
                        "John", "Mariam", "Alex", "Mohammed", "Vincent", "Alex"));

        // Lambdas (ejemplos)
        new Thread(() -> System.out.println("Hello Lambdas!")).start();

        names.forEach((name) -> System.out.println("Hello " + name + "!"));
        names.forEach(name -> System.out.println("Hello " + name + "!"));

        names.forEach((name) -> {
            System.out.println("Hi " + name + "!");
            System.out.println("Bye " + name + "!");
        });

        names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println);

        // Streams (ejemplos)
        System.out.println("Streams with filter");
        names.stream()
                .filter(name -> name.startsWith("M"))
                .forEach(System.out::println);

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John"));
        students.add(new Student(2, "Mariam"));
        students.add(new Student(3, "Alex"));
        students.add(new Student(4, "Mohammed"));
        students.add(new Student(5, "Vincent"));
        students.add(new Student(6, "Alex"));

        System.out.println("Streams with map");
        List<Teacher> teachers = students.stream()
                .map(student -> new Teacher(student.getId(), student.getName()))
                .toList();
        System.out.println(teachers);

        System.out.println("Streams with map (another way)");
        List<Teacher> teachers2 = students.stream()
                .map((student) -> {
                    Teacher teacher = new Teacher();
                    teacher.setId(student.getId());
                    teacher.setName(student.getName());
                    return teacher;
                })
                .toList();
        System.out.println(teachers2);

        System.out.println("Streams with sorted");
        students.stream().sorted().forEach(System.out::println);
        System.out.println(students);

        System.out.println("Streams with distinct");
        students.stream().distinct().forEach(System.out::println);

        System.out.println("Streams with limit");
        students.stream().limit(3).forEach(System.out::println);

        System.out.println("Streams with skip");
        students.stream().skip(3).forEach(System.out::println);

        System.out.println("Streams with count");
        long count = students.stream().count();
        System.out.println(count);

        System.out.println("Streams with reduce");
        int sum = students.stream()
                .map(Student::getId)
                .reduce(0, (id1, id2) -> id1 + id2);
        System.out.println(sum);

        int sum2 = students.stream()
                .map(Student::getId)
                .reduce(0, Integer::sum);
        System.out.println(sum2);

        String namesConcatenated = students.stream()
                .map(Student::getName)
                .reduce("", (name1, name2) -> name1 + " " + name2);
        System.out.println(namesConcatenated);

        String namesConcatenated2 = students.stream()
                .map(Student::getName)
                .reduce("", String::concat);
        System.out.println(namesConcatenated2);
    }
}
