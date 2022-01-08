package Lesson_07;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class MyUtils {

    //Создание скриншота, например при ошибке
    public static void makeScreenshot(WebDriver driver, String filename) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./Screenshot/" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
