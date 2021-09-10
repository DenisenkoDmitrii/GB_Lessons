package Lesson_02;

import java.util.Scanner;

/*
Lesson_02 (GB.Java 1)
Denisenko Dmitrii (10.09.2021)
 */
public class Lesson_02 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        checkSumm10_20();
        positiveOrNegative();
        repeatString();
    }

    static void checkSumm10_20() {
        /* Реализация с if
        if ((a + b) >= 10 && (a + b) <= 20) {
            String s = "true";
            return s;
        } else {
            String s = "false";
            return s;
        } */
        // Реализация с тернарным оператором
        System.out.println("Введите первое число");
        int a = scanner.nextInt();
        System.out.println("Введите второе число");
        int b = scanner.nextInt();
        String s = ((a + b) >= 10 && (a + b) <= 20) ? " true" : " false";
        System.out.println("Проверка чиcел " + a + " и числа " + b + " :" + s);
    }

    static void positiveOrNegative() {
        // Реализация с тернарным оператором
        System.out.println("Введите число со знаком + или знаком -");
        int a = scanner.nextInt();
        String s = (a < 0) ? "Число " + a + " отрицательное" : "Число " + a + " положительное";
        System.out.println(s);
    }

    static void repeatString() {
        System.out.println("Введите любое слово");
        String text = scanner.next();
        System.out.println("Введите число повторений");
        int amount = scanner.nextInt();
        for (int i = 0; i < amount; i++) {
            System.out.println(text);
        }
    }
}
