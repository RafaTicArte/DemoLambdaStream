package DemoLambdaStream;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        return this.name.compareTo(s.name);
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        if (this == obj){
            isEquals = true;
        } else if (obj == null || getClass() != obj.getClass()) {
            isEquals = false;
        } else {
            Student student = (Student) obj;
            isEquals = Objects.equals(name, student.name);
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
