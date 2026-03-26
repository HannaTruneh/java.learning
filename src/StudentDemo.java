import java.util.List;
import java.util.ArrayList;

abstract class Course {

    String courseName;
    int numberOfHours;

    public Course(String courseName, int numberOfHours) {
        this.courseName = courseName;
        this.numberOfHours = numberOfHours;
    }

    abstract void courseInfo();

}

class MathCourse extends Course {

    private String level;

    public MathCourse(String courseName, int numberOfHours, String level) {
        super(courseName, numberOfHours);
        this.level = level;
    }

    @Override
    void courseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Number of Hours: " + numberOfHours);
        System.out.println("Level: " + level);
    }
}

class ProgramingCourse extends Course {

    private String language;

    public ProgramingCourse(String courseName, int numberOfHours, String language) {
        super(courseName, numberOfHours);
        this.language = language;
    }

    @Override
    void courseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Number of Hours: " + numberOfHours);
        System.out.println("Programming Language: " + language);
    }
}

interface Student {

    String getName();

    void addCourse(Course course);

}

class UniversityStudent implements Student {

    private String name;
    List<Course> courses;

    public UniversityStudent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addCourse(Course course) {
        System.out.println(name + " has added the course: " + course.courseName);
    }
}


public class StudentDemo {

    public static void main(String[] args) {
        MathCourse mathCourse = new MathCourse("Calculus", 40, "Advanced");
        mathCourse.courseInfo();

        ProgramingCourse programingCourse = new ProgramingCourse("Java Programming", 60, "Java");
        programingCourse.courseInfo();

        UniversityStudent student = new UniversityStudent("Alice");
        student.addCourse(mathCourse);
        student.addCourse(programingCourse);


        UniversityStudent student2 = new UniversityStudent("Bob");
        student2.addCourse(programingCourse);

        List<UniversityStudent> students = new ArrayList<>();
        students.add(student);
        students.add(student2);


        List<Course> courses = new ArrayList<>();
        courses.add(mathCourse);
        courses.add(programingCourse);

        for (UniversityStudent s : students) {
            System.out.println("Student: " + s.getName());
            for (Course c : courses) {
                s.addCourse(c);
            }
        }
    }
}

