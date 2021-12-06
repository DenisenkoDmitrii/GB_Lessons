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

public class FilterNolegalAdvertClosed {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //============================Фильтр: Незаконная Реклама - Закрыто=========================================
        driver.get("http://dozor.openvlz34.ru");

        WebElement webElement = driver.findElement(By.id("problemCategoriesSearchId"));
        webElement.click();
        webElement = driver.findElement(By.xpath("//*[@id=\"problemCategoriesSearchId\"]/option[6]"));
        webElement.click();
        webElement = driver.findElement(By.id("problemStatusSearchId"));
        webElement.click();
        webElement = driver.findElement(By.xpath("//*[@id=\"problemStatusSearchId\"]/option[6]"));
        webElement.click();
        webElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/button/i"));
        webElement.click();
        webElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[1]/div/span[1]/span[2]"));
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.visibilityOf(webElement));
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./Screenshot/FilterNolegalAdvertClosed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
