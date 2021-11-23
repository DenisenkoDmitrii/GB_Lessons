package Lesson_09;

import java.util.ArrayList;

public class Student {

    private String name;
    ArrayList<Course> courses = new ArrayList<Course>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public ArrayList<Course> getAllCourses() {
        return courses;
    }

    public int coursesCount() {
        return courses.size();
    }

    @Override
    public String toString(){
        return name;
    }
}

