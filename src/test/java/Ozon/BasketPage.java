package Ozon;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='menu-item m-cart']//a[@class='link']")
    private WebElement basketButton;

    @FindBy(xpath = "//button[contains(text(),'Удалить выбранные')]")
    private  WebElement delSelect;

    @FindBy(xpath = "//button[contains(text(),'Удалить все')]")
    private WebElement delFull;

    @FindBy(xpath = "//div[@class='buttons m-single']//button[@type='submit'][contains(text(),'Удалить')]")
    private WebElement delConfitm;

    @FindBy(xpath = "//span[contains(text(),'Петр')]")
    private WebElement clickMyOzonLogin;

    @FindBy(xpath = "//span[contains(.,'Выйти')]")
    private WebElement clickExit;

    @FindBy(xpath = "//h1[@class='cart-title']")
    private WebElement basketEmty;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void setDelSelect(){
        delSelect.click();
    }
    public void setDelFull(){
        delFull.click();
    }
    public void setDelConfitm(){
        delConfitm.click();
    }
    public void setClickMyOzonLogin(){
        clickMyOzonLogin.click();
    }
    public void setClickExit(){
        clickExit.click();
    }
    public void setBasketEmty(){
        basketEmty.getText();
    }



    public void setBasketButtonButtonClick(){
        try {
            basketButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='split simple m-first m-last']")));
        }
        catch (NoSuchElementException ex){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Корзина')]")));
            basketButton.click();
        }
    }
}
