package Lesson_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private String user_name = "dd777777777777777777777777@dd.dd";
    private String user_password = "123456";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Поле "Учётная запись"
    @FindBy(id = "UserName")
    private WebElement userName;

    //Поле "Пароль"
    @FindBy(id = "Password")
    private WebElement password;

    //Кнопка "Вход"
    @FindBy(className = "login100-form-btn")
    private WebElement enterButton;

    public LoginPage clickEnterButton() {
        enterButton.click();
        return this;
    }

    public LoginPage enterUserName() {
        userName.sendKeys(user_name);
        return this;
    }

    public LoginPage enterPassword() {
        password.sendKeys(user_password);
        return this;
    }

}
