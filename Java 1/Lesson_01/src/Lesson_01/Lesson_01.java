package Lesson_01;

public class Lesson_01 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = 15;
        String sum = ((a + b) >= 0) ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(sum);
    }

    public static void printColor() {
        int value = 5;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a1 = 10;
        int b1 = 15;
        String sum1 = (a1 >= b1) ? "a >= b" : "a < b";
        System.out.println(sum1);
    }
}
