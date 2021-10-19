package Lesson_05;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String telephone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "ФИО: " + fullName + ", должность: " + position + ", email: " + email +
                ", телефон: " + telephone + ", зарплата: " + salary + ", возраст: " + age + ";";
    }
}
