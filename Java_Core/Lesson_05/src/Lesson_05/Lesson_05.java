package Lesson_05;

import java.io.*;

/*
Lesson_05 (GB.Java Core)
Denisenko Dmitriy (09.11.2021)
 */
public class Lesson_05 {

    public static void main(String[] args) {

        File file = new File("lesson.csv");
        AppData appData = new AppData();
        //System.out.println(appData.getHeader());
        //System.out.println(appData.getData());
        try (Writer out = new PrintWriter(file)) {
            out.write(appData.getHeader());
            out.write(appData.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String readStr;
            while ((readStr = in.readLine()) != null) {
                System.out.println(readStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
