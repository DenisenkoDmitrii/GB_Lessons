package Lesson_05;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

/*
Lesson_05 (GB.Java_AutoTest_WebUI)
Denisenko Dmitriy (15.12.2021)
 */
public class Lesson_05Test {

    static WebDriver driver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void exit() {
        driver.quit();
    }

    //============================Регистрация=========================================
    @Test
    void registration() {
        WebElement webElement;
        driver.get("http://dozor.openvlz34.ru");
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul[1]/li[1]/a")).click();
        driver.findElement(By.id("Email")).sendKeys("dd17122021d1@dd.dd");  //dd17122021d1@dd.dd ещё не регистрировался
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        webElement = driver.findElement(By.className("login100-form-btn"));
        webElement.click();
        assertEquals("Выйти", driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul/li[4]/a")).getText());
    }

    //============================Логин=========================================
    @Test
    void login() {
        driver.get("http://dozor.openvlz34.ru");
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul[1]/li[2]/a")).click();
        driver.findElement(By.id("UserName")).sendKeys("dd777777777777777777777777@dd.dd");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.className("login100-form-btn")).click();
        assertEquals("Кабинет", driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul/li[1]/a")).getText());
    }

    //============================Фильтр: Незаконная Реклама - Закрыто=========================================
    @Test
    void FilterNolegalAdvertClosed() {
        driver.get("http://dozor.openvlz34.ru");
        driver.findElement(By.id("problemCategoriesSearchId")).click();
        driver.findElement(By.xpath("//*[@id=\"problemCategoriesSearchId\"]/option[6]")).click();
        driver.findElement(By.id("problemStatusSearchId")).click();
        driver.findElement(By.xpath("//*[@id=\"problemStatusSearchId\"]/option[6]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/button/i")).click();
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[1]/div/span[1]/span[2]"));
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.visibilityOf(webElement));
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./Screenshot/FilterNolegalAdvertClosed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("Незаконная реклама", driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[1]/div/span[1]/span[2]")).getText());
    }

    //============================Переход на страницу и обратно=========================================
    @Test
    void watsAppJumpNewWindowAndReturn() {
        driver.get("http://dozor.openvlz34.ru");
        driver.findElement(By.linkText("Горячая линия по поливу")).click();
        driver.getTitle();
        assertEquals("Поделиться в WhatsApp", driver.getTitle());
        driver.navigate().back();
        assertEquals("Главная - Волжский Дозор", driver.getTitle());
    }

    //============================Правила пользования ПДФ и Пользовательское соглашение doc - открываются в новых окнах=========================================
    @Test
    void twoNewWindows() {
        driver.get("http://dozor.openvlz34.ru");
        driver.findElement(By.xpath("/html/body/header/div[2]/div/div/button[1]")).click();
        Actions actions = new Actions(driver);

        actions
                .click(driver.findElement(By.linkText("Правила пользования")))
                .build()
                .perform();
        List<String> windowHandles = new ArrayList(driver.getWindowHandles());
        assert (driver.getWindowHandles().size() == 2);
        driver.switchTo().window(windowHandles.get(0));
        assertEquals("Главная - Волжский Дозор", driver.getTitle());
        actions
                .click(driver.findElement(By.linkText("Пользовательское соглашение")))
                .build()
                .perform();
        assert (driver.getWindowHandles().size() == 3);
        driver.switchTo().window(windowHandles.get(0));
        assertEquals("Главная - Волжский Дозор", driver.getTitle());
    }
}
