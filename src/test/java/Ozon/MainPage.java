package Ozon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//span[contains(text(),'Мой OZON')]")
    private WebElement clickMyOzon;



    @FindBy(xpath = "//span[contains(.,'Вход или регистрация')]")
    private WebElement input;

    @FindBy(linkText = "Войти по почте")
    private WebElement toEnterByMail;

    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement search;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void openLink() {
        driver.get("https://www.ozon.ru");
    }

    public void setClickMyOzon() {
        clickMyOzon.click();
    }

    public void setInput() {
        input.click();
    }

    public void setToEnterByMail() {
        toEnterByMail.click();
    }
    public void setSearch(){
        search.sendKeys("IPhone");
    }
    public void setButtonSearch(){
        buttonSearch.click();
    }

}
