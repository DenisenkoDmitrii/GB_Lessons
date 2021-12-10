package Lesson_09;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson_09 {
    public static void main(String[] args) {
        //список курсов
        Course course1 = new Course("Курс_1");
        Course course2 = new Course("Курс_2");
        Course course3 = new Course("Курс_3");
        Course course4 = new Course("Курс_4");

        //Список студентов
        Student student1 = new Student("Студент_1");
        Student student2 = new Student("Студент_2");
        Student student3 = new Student("Студент_3");
        Student student4 = new Student("Студент_4");
        Student student5 = new Student("Студент_5");

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        //Добавление курсов
        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);
        student2.addCourse(course1);
        student2.addCourse(course3);
        student3.addCourse(course3);
        student3.addCourse(course4);
        student4.addCourse(course3);
        student5.addCourse(course1);
        student5.addCourse(course2);
        student5.addCourse(course3);
        student5.addCourse(course4);

        //Получаем сначала список всех курсов на которые подписанны все студенты и через LinkedHashSet - список уникальных курсов
        LinkedHashSet<String> allCourses = new LinkedHashSet<>();
        students.stream()
                .forEach(x -> allCourses.addAll(x.getAllCourses()
                        .stream()
                        .map(y -> y.getName())
                        .collect(Collectors.toList())
                ));
        System.out.println(allCourses);

        //Получаем сначала список всех курсов на которые подписанны все студенты и через distinct() - список уникальных курсов
        ArrayList<String> allCourses2 = new ArrayList<>();
        students.stream()
                .forEach(x -> allCourses2.addAll(x.getAllCourses()
                        .stream()
                        .map(y -> y.getName())
                        .collect(Collectors.toList())
                ));

        allCourses2.stream()
                .distinct()
                .forEach(System.out::println);

        //Получаем 1 студента с максимальным количеством курсов и методом coursesCount() (вариант 1)
        System.out.println(students.stream()
                .reduce((x1, x2) -> x1.coursesCount() > x2.coursesCount() ?));
        x1 : x2
        //Получаем 3 студента с максимальным количеством курсов через courses.size() (вариант 2)
        students.stream()
                .sorted((x1, x2) -> x2.courses.size() - x1.courses.size())
                .limit(3)
                .forEach(System.out::println);

        //Получаем список студентов, которые посещают запрашиваемый ку
        // не сделал, в процессе







       /* Вывожу количество курсов у студентов
        System.out.println(students.stream()
                .map(x -> x.getAllCourses()
                        .stream()
                        .map((x1) -> x1.name)
                        .count())
                .collect(Collectors.toList()));
        */


    }
}
