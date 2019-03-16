package Ozon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAndPassword {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Почта'])[1]/following::input[1]")
    private WebElement login;

    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement pass;

    @FindBy(xpath = "//button[@type=\"button\"]")
    private WebElement loginButton;


    public LoginAndPassword(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }
    public void setLogin(){
        login.getText();
    }
    public void sign(){

        login.sendKeys("bellozontest@yandex.ru");
        pass.sendKeys("qwer1234");
        loginButton.click();
    }
    public WebElement getLogin(){
        return login;

    }

    public WebElement getPass() {
        return pass;
    }


}
