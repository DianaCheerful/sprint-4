package ru.yandex.praktikum.tests.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.tests.constants.TestConstants.OrderButtonPosition;

import java.util.ArrayList;

import static ru.yandex.praktikum.tests.constants.TestConstants.OrderButtonPosition.UP;


public class MainPageObject {

    private final WebDriver driver;
    private final By cookieConfirmation = By.id("rcc-confirm-button");
    private final By logoScooter = By.xpath("//a[@class = 'Header_LogoScooter__3lsAR']");
    private final By logoYandex = By.xpath("//a[@class = 'Header_LogoYandex__3TSOI']");
    private final By orderUpButton = By.xpath("//button[@class = 'Button_Button__ra12g' and text() = 'Заказать']");
    private final By orderDownButton = By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/descendant::button[text() = 'Заказать']");
    private final By orderStatus = By.xpath("//button[text() = 'Статус заказа']");
    private final By checkOrderStatusGoButton = By.xpath("//button[text()= 'Go!']");
    private final By orderNumberInputField = By.xpath("//input[@placeholder= 'Введите номер заказа']");
    public final By searchFieldYandex = By.xpath("//*[text() = 'Поиск Яндекса']");


    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmCookies() {
        if (driver.findElement(cookieConfirmation).isDisplayed()) {
            driver.findElement(cookieConfirmation).click();
        }
    }

    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(orderUpButton).isDisplayed());
    }

    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(searchFieldYandex));
    }

    public void checkOrderByNumber(String orderNumber) {
        driver.findElement(orderStatus).click();
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(checkOrderStatusGoButton).isDisplayed());
        driver.findElement(orderNumberInputField).sendKeys(orderNumber);
        driver.findElement(checkOrderStatusGoButton).click();
    }

    public void clickOrderButton(OrderButtonPosition buttonPosition) {
        if (buttonPosition == UP) {
            driver.findElement(orderUpButton).click();
        } else {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView();", driver.findElement(orderDownButton));
            driver.findElement(orderDownButton).click();
        }
    }
}