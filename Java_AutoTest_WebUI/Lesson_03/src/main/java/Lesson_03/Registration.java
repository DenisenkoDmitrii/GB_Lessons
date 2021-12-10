package Lesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/*
Lesson_03 (GB.Java_AutoTest_WebUI)
Denisenko Dmitriy (02.12.2021)
 */
public class Registration {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless"); (не запускает на экране компьютера)
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.visibilityOf(webElement)); (явное ожидание)

        //============================Регистрация=========================================
        driver.get("http://dozor.openvlz34.ru");
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul[1]/li[1]/a"));
        //Использую полный xpath вместо id, т.к. на этом сайте под одним id - несколько элементов (в частности id="registerLink" в header и в body), почему так, для меня загадка
        webElement.click();
        webElement = driver.findElement(By.id("Email"));
        webElement.sendKeys("dd77@dd.dd");
        webElement = driver.findElement(By.id("Password"));
        webElement.sendKeys("123456");
        webElement = driver.findElement(By.id("ConfirmPassword"));
        webElement.sendKeys("123456");
        webElement = driver.findElement(By.className("login100-form-btn"));
        webElement.click();

        //webElement.submit(); //как нажатие Enter
        //driver.quit();



    }
}
