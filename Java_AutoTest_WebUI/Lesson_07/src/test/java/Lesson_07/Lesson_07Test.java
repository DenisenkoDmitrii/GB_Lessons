package Lesson_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lesson_07Test {
    static WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    public void openMainPage() {
        driver.get("http://dozor.openvlz34.ru");
    }

    @AfterEach
    public void tearDown() {
        // Вывод всех ошибок браузера после каждого теста
        List<LogEntry> allLogRows = driver.manage().logs().get(LogType.BROWSER).getAll();
        if (allLogRows.size() > 0) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });
           //Assertions.fail();
        }
    }

    @AfterAll
    public static void exit() {
        driver.quit();
    }

    //============================Регистрация (отключается - проверить @Disabled)=========================================
    @Test
    @Disabled
    @Severity(SeverityLevel.BLOCKER)
    void registration() {
        WebElement webElement;
        new MainPage(driver).clickRegistration();
        new RegistrationPage(driver)
                .enterEmail()
                .enterPassword()
                .enterConfirmPassword()
                .clickRegistrationButton();
        assertEquals("Выйти", driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul/li[4]/a")).getText());
    }

    //============================Логин=========================================
    @Test
    @Severity(SeverityLevel.CRITICAL)
    void login() {
        driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul[1]/li[2]/a")).click();

        new MainPage(driver).clickLogin();
        new LoginPage(driver)
                .enterUserName()
                .enterPassword()
                .clickEnterButton();
        assertEquals("Кабинет", driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul/li[1]/a")).getText());
    }

    //============================Фильтр: Незаконная Реклама - В работе=========================================
    @Test
    @Severity(SeverityLevel.MINOR)
    public void FilterNolegalAdvertInWork() {
        String result = new MainPage(driver)
                .clickCategory_5()
                .clickStatus_2()
                .clickFilterButton()
                .getFilterCategoryText();
        //Скриншот (скрин можно делать при использовании отслеживания и протоколирования действия драйвера WebDriverEventListener например на @Override public void onException(Throwable throwable, WebDriver driver) { тут создание скрина }
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd время HH-mm");
        MyUtils.makeScreenshot(driver, "Незаконная Реклама-В работе " + formatDate.format(date) + ".png");
        //В названии скриншотяр рекомендуется указывать название класса и пакета, пример: "Lesson_07Test.FilterNolegalAdvertInWork " + formatDate.format(date) + ".png"
        //Скриншот готов
        Assertions.assertEquals("Незаконная реклама", result);
        String filterStatusText = new MainPage(driver).getFilterStatusText();
        Assertions.assertEquals("В работе", filterStatusText);
    }

    //============================Переход на страницу и обратно========================================
//В этом месте не менял с 05 урока ничего
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    void watsAppJumpNewWindowAndReturn() {
        driver.findElement(By.linkText("Горячая линия по поливу")).click();
        driver.getTitle();
        assertEquals("Поделиться в WhatsApp", driver.getTitle());
        driver.navigate().back();
        assertEquals("Главная - Волжский Дозор", driver.getTitle());
    }

    //============================Правила пользования ПДФ и Пользовательское соглашение doc - открываются в новых окнах=========================================
//В этом месте не менял с 05 урока ничего
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    void twoNewWindows() {
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
