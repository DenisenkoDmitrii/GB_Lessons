package Lesson_02;

import java.util.Arrays;

public class MyArray {
    String[][] array;

    public MyArray(String array11, String array12, String array13, String array14, String array21, String array22, String array23, String array24, String array31, String array32, String array33, String array34, String array41, String array42, String array43, String array44) {
        array = new String[][]{{array11, array12, array13, array14}, {array21, array22, array23, array24}, {array31, array32, array33, array34}, {array41, array42, array43, array44}};
    }

    public void info() {
        System.out.println(Arrays.deepToString(array));
    }

    public int sum() {
        int sum = 0;
        int y = array.length;
        for (int i = 0; i < y; i++) {
            int x = array[i].length;
            for (int j = 0; j < x; j++) {
                sum = sum + Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }
}
