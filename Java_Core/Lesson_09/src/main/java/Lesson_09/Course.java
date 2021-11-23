package Lesson_09;

public class Course {
    String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
