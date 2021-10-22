package Lesson_02;

import java.util.Arrays;
/*
Lesson_02 (GB.Java Core)
Denisenko Dmitriy (22.10.2021)
 */
public class Lesson_02 {

    public static void main(String[] args) {
        /* Не относится к заданию, эксперементировал с конструктором.
        System.out.println("Не относится к заданию, экспериментировал с конструктором");
        MyArray myArray = new MyArray("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "2", "3", "4", "5", "6");
        myArray.info();
        System.out.println(myArray.sum());
        */
        // Проверочный массив
        String[][] arrayString = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "0", "1", "2"}, {"3", "4", "5", "6"}};
        // Массив с размером не 4х4
        String[][] arrayString1 = {{"1", "2", "3", "4", "5"}, {"5", "6", "7", "8"}, {"9", "0", "1", "2"}, {"3", "4", "5", "6"}};
        // Массив с символом
        String[][] arrayString2 = {{"1", "2", "3", "d"}, {"5", "6", "7", "8"}, {"9", "0", "1", "2"}, {"3", "4", "5", "6"}};

        try {
            System.out.println("Правильный массив\n");
            mySum(arrayString);
            System.out.println("Массив с размером не 4х4\n");
            mySum(arrayString1);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Правильный массив\n");
            mySum(arrayString);
            System.out.println("Массив с символом\n");
            mySum(arrayString2);

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void mySum(String[][] arrayString) throws MyArraySizeException, MyArrayDataException {
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString.length != 4 || arrayString[i].length != 4) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        int y = arrayString.length;
        for (int i = 0; i < y; i++) {
            int x = arrayString[i].length;
            for (int j = 0; j < x; j++) {
                if (tryParseInt(arrayString[i][j])) {
                    sum = sum + Integer.parseInt(arrayString[i][j]);
                } else {
                    throw new MyArrayDataException();
                }
            }
        }
        System.out.println("Сумма элементов массива: " + sum + "\n");
    }

    static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
