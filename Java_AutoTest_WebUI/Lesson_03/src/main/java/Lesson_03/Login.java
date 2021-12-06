package Lesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Login {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //============================Логин=========================================
        driver.get("http://dozor.openvlz34.ru");

        driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul[1]/li[2]/a")).click();
        driver.findElement(By.id("UserName")).sendKeys("dd777777777777777777777777@dd.dd");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.className("login100-form-btn")).click();

        //Переписал с такого варианта
        //WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul[1]/li[2]/a"));
        //webElement.click();


    }
}
