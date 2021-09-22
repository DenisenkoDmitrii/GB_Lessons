package Lesson_05;

public class Lesson_05 {

    public static void main(String[] args) {
        Employee employeesArray[] = new Employee[5];
        employeesArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",
                30000, 30);
        employeesArray[1] = new Employee("Petrov Ivan", "HR-manager", "Petrov@mailbox.com", "892354825",
                40000, 41);
        employeesArray[2] = new Employee("Boshirov Ivan", "Developer", "Boshirov@mailbox.com", "892654822",
                50000, 32);
        employeesArray[3] = new Employee("Sokolov Ivan", "QA engineer", "Sokolov@mailbox.com", "892365482",
                50000, 42);
        employeesArray[4] = new Employee("Sidorov Ivan", "Kitchener", "Sidorov@mailbox.com", "892658242",
                20000, 34);

        System.out.println("Данные о сотрудниках старше 40 лет");
        // Реализация с циклом foreach
        for (Employee i : employeesArray) {
            if (i.getAge() >= 40) {
                System.out.println(i.toString());
            }
        }

        System.out.println();
        // Реализация обычная
        System.out.println("Данные о сотрудниках младьше 40 лет");
        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getAge() <= 40) {
                System.out.println(employeesArray[i].toString());
            }
        }
    }
}
