package Lesson_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    //Войти
    @FindBy(xpath ="/html/body/div[2]/nav/div/ul[1]/li[2]/a")
    private WebElement logIn;

    //Регистрация
    @FindBy(xpath ="/html/body/div[2]/nav/div/ul[1]/li[1]/a")
    private WebElement registration;

    //Категория:  (выпадающий список)
    @FindBy(id ="problemCategoriesSearchId")
    private WebElement category;

        //Категория: Определяется
        @FindBy(xpath ="//*[@id=\"problemCategoriesSearchId\"]/option[2]")
        private WebElement category_1;

         //Категория: Запрещенная парковка
         @FindBy(xpath ="//*[@id=\"problemCategoriesSearchId\"]/option[3]")
         private WebElement category_2;

         //Категория: Здания, объекты, конструкции
         @FindBy(xpath ="//*[@id=\"problemCategoriesSearchId\"]/option[4]")
         private WebElement category_3;

         //Категория: Нарушение благоустройства
         @FindBy(xpath ="//*[@id=\"problemCategoriesSearchId\"]/option[5]")
         private WebElement category_4;

         //Категория: Незаконная реклама
         @FindBy(xpath ="//*[@id=\"problemCategoriesSearchId\"]/option[6]")
         private WebElement category_5;

         // и так далее (не заполнял)

            //Категория: текст тервого сообщения
            @FindBy(xpath ="/html/body/div[3]/div/div[2]/div[1]/div/span")
            private WebElement category_text;

    //Статус:   (выпадающий список)
    @FindBy(id ="problemStatusSearchId")
    private WebElement status;

          //Статус: Новая
          @FindBy(xpath ="//*[@id=\"problemStatusSearchId\"]/option[2]")
          private WebElement status_1;

          //Статус: В работе
          @FindBy(xpath ="//*[@id=\"problemStatusSearchId\"]/option[3]")
          private WebElement status_2;

          //Статус: Отложена
          @FindBy(xpath ="//*[@id=\"problemStatusSearchId\"]/option[4]")
          private WebElement status_3;

          // и так далее (не заполнял)

    //Фильтр категории и статуса (кнопка)
          @FindBy(xpath ="//*[@id=\"messageList\"]/div/div[1]/div/div/div[3]/button")
          private WebElement filterButton;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage clickCategory_5(){
        category_5.click();
        return this;
    }

    public MainPage clickStatus_2(){
        status_2.click();
        return this;
    }

    public MainPage clickFilterButton(){
        filterButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.visibilityOf(category_text));
        return this;
    }

    public String getFilterCategoryText(){
        return driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/span")).getText();
    }

    public String getFilterStatusText(){
        return driver.findElement(By.xpath("//*[@id=\"messageList\"]/div/div[2]/div[1]/div/div[1]/div/span[2]/span")).getText();
    }

    public MainPage clickRegistration(){
        registration.click();
        return this;
    }

    public MainPage clickLogin(){
        logIn.click();
        return this;
    }






}
