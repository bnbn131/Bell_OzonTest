package Ozon;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;

public class OzonTest extends Settings {

    @Test
    public void ozonTest() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginAndPassword loginAndPassword = PageFactory.initElements(driver, LoginAndPassword.class);
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        BasketPage basketPage = PageFactory.initElements(driver,BasketPage.class);

        mainPage.openLink();

        mainPage.setClickMyOzon();
        mainPage.setInput();
        mainPage.setToEnterByMail();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginAndPassword.sign();
        waiting();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//input[@type='text']")).click();
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Почта'])[1]/following::input[1]")).sendKeys("123");
        //driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("IPhone");
        mainPage.setSearch();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage.setButtonSearch();
        waiting();
        //driver.findElement(By.xpath("//div[@index = '1']")).click();
        //div[@id='138262687']

        //14 товаров добавляет
        List<String> basketList = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@index]"));

        for (int i = 0; i < elementList.size(); i++) {
            if((i%2)!=0 || i == 1) {
                String id = driver.findElement(By.xpath("//div[@index=\"" + i + "\"]/div")).getAttribute("id");
                basketList.add(id);
                searchPage.addToCart(By.xpath("//div[@index=\"" + i + "\"]//button/span"),  i);
            }
        }


        waiting();
        basketPage.setBasketButtonButtonClick();
        for(int i = 0; i < basketList.size(); i++){
            assertNotNull(driver.findElements(By.xpath("//div[@index=\"" + basketList.get(i) + "\"]")));
        }

        //из-за того, что по e-mail можно создать только для ЮР-лиц, то корзина разбилась на 2 части, для физических и ЮР.лиц
        basketPage.setDelSelect();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basketPage.setDelConfitm();
        waiting();
        basketPage.setDelFull();
        basketPage.setDelConfitm();

        waiting();
        basketPage.setClickMyOzonLogin();
        basketPage.setClickExit();

        mainPage.setClickMyOzon();
        mainPage.setInput();
        mainPage.setToEnterByMail();
        loginAndPassword.sign();

        //driver.findElement(By.xpath("//h1[@class='cart-title']")).isDisplayed();

        basketPage.setBasketEmty();





    }


    }

