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
        createArray();
        System.out.println(" Задание 2 ");
        createArray100();
        System.out.println(" Задание 3 ");
        multiplyLessThen_6();
        System.out.println(" Задание 4 ");
        arrayDiagonal();
        System.out.println(" Задание 5 ");
        arrayWithLen(3, 3);
        System.out.println(" Задание 6 ");
        arrayMaxMin();
    }

    static void createArray() {
        int array1[] = new int[10];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(array1));
        for (int i = 0; i < array1.length; i++) {
            int a = (array1[i] == 0) ? 1 : 0;
            array1[i] = a;
        }
        System.out.println(Arrays.toString(array1));
    }

    static void createArray100() {
        int array2[] = new int[100];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }
        System.out.println(Arrays.toString(array2));
    }


    static void multiplyLessThen_6() {
        int array3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array3));
        for (int i = 0; i < array3.length; i++) {
            int a = (array3[i] <= 6) ? array3[i] * 2 : array3[i];
            array3[i] = a;
        }
        System.out.println(Arrays.toString(array3));
    }

    static void arrayDiagonal() {
        int array4[][] = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0, k = array4[i].length - 1; j < 5; j++, k--) {
                if (i == j || i == k) {
                    array4[i][j] = 1;
                    System.out.print(array4[i][j] + " ");
                } else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    static void arrayWithLen(int len, int initialValue) {
        int array5[] = new int[len];
        for (int i = 0; i < array5.length; i++) {
            array5[i] = initialValue;
        }
        System.out.println(Arrays.toString(array5));
    }

    static void arrayMaxMin() {
        int array6[] = new int[20];
                for (int i = 0; i < array6.length; i++) {
            array6[i] = random.nextInt(31);
        }
        System.out.println(Arrays.toString(array6));
        int max = array6[0];
        int min = array6[0];
        for (int i = 0; i < array6.length; i++) {
            if (array6[i] < min) {
                min = array6[i];
            }
        }
        for (int i1 = 0; i1 < array6.length; i1++) {
            if (array6[i1] > max) {
                max = array6[i1];
            }
        }
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
    }
}





