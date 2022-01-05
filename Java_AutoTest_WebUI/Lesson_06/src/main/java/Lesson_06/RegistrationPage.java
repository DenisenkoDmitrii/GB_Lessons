package Lesson_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private String user_name = "dd04012022d2@dd.dd"; //dd04012022d2@dd.dd ещё не регистрировал
    private String user_password = "123456";

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Поле "Учётная запись"
    @FindBy(id = "Email")
    private WebElement email;

    //Поле "Пароль"
    @FindBy(id = "Password")
    private WebElement password;

    //Поле "Подтверждение Пароля"
    @FindBy(id = "ConfirmPassword")
    private WebElement сonfirmPassword;

    //Кнопка "Регистрация"
    @FindBy(className = "login100-form-btn")
    private WebElement registrationButton;

    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return this;
    }

    public RegistrationPage enterEmail() {
        email.sendKeys(user_name);
        return this;
    }

    public RegistrationPage enterPassword() {
        password.sendKeys(user_password);
        return this;
    }

    public RegistrationPage enterConfirmPassword() {
        сonfirmPassword.sendKeys(user_password);
        return this;
    }
}
