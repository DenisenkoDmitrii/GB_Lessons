package Lesson_03;

import java.util.Random;
import java.util.Arrays;

/*
Lesson_03 (GB.Java 1)
Denisenko Dmitrii (15.09.2021)
 */
public class Lesson_03 {
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(" Задание 1 ");
        createArray(10);
        System.out.println(" Задание 2 ");
        createArray100();
        System.out.println(" Задание 3 ");
        multiplyLessThen_6();
        System.out.println(" Задание 4 ");
        arrayDiagonal(7);
        System.out.println(" Задание 5 ");
        arrayWithLen(3, 3);
        System.out.println(" Задание 6 ");
        arrayMaxMin();
        System.out.println(" Задание 7 ");
        checkArray(10);
    }

    static void createArray(int size) {
        int array[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int a = (array[i] == 0) ? 1 : 0;
            array[i] = a;
        }
        System.out.println(Arrays.toString(array));
    }

    static void createArray100() {
        int array[] = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    static void multiplyLessThen_6() {
        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int a = (array[i] <= 6) ? array[i] * 2 : array[i];
            array[i] = a;
        }
        System.out.println(Arrays.toString(array));
    }

    static void arrayDiagonal(int size) {
        int array[][] = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0, k = array[i].length - 1; j < array.length; j++, k--) {
                if (i == j || i == k) {
                    array[i][j] = 1;
                    System.out.print(array[i][j] + " ");
                } else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    static void arrayWithLen(int len, int initialValue) {
        int array[] = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        System.out.println(Arrays.toString(array));
    }

    static void arrayMaxMin() {
        int array[] = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(31);
        }
        System.out.println(Arrays.toString(array));
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        for (int i1 = 0; i1 < array.length; i1++) {
            if (array[i1] > max) {
                max = array[i1];
            }
        }
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
    }

    static void checkArray(int size) {
        int array[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(array));
        // тестовый массив int array1[] = {1,1,1,1,0,0,1,1,1,1};
        int left = 0;
        int right = 0;
        int total = 0;
        String checkBalance = "false";

        for (int i = 0; i < array.length; i++) {
            total = total + array[i];
        }
        right = total;
        for (int i = 0; i < array.length; i++) {
            right = right - array[i];
            left = left + array[i];
            if (left == right) {
                checkBalance = "true";
                System.out.println("Border between array[" + i + "] and array[" + (i + 1) + "]");
                break;
            }
        }
        System.out.println(checkBalance);
    }
}





