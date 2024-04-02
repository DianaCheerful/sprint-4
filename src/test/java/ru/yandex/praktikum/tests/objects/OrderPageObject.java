package ru.yandex.praktikum.tests.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.tests.constants.OrderData;

public class OrderPageObject {

    private final WebDriver driver;

    private final By firstNameField = By.xpath("//input[@placeholder = '* Имя']");
    private final By lastNameField = By.xpath("//input[@placeholder = '* Фамилия']");
    private final By addressField = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By subwayField = By.xpath("//input[@placeholder = '* Станция метро']");
    private final By phoneField = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By continueButton = By.xpath("//button[text() = 'Далее']");
    private final By rentDateField = By.xpath("//input[@placeholder = '* Когда привезти самокат']");
    private final By rentDurationField = By.xpath("//div[text() = '* Срок аренды']");
    private final By submitButton = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By confirmButton = By.xpath("//button[text() = 'Да']");
    private final By watchStatus = By.xpath("//button[text() = 'Посмотреть статус']");
    private final By successHeader = By.xpath("//div[text() = 'Заказ оформлен']");


    public OrderPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public String createOrder(OrderData orderData) {
        fillFirstName(orderData.getFirstName());
        fillLastName(orderData.getLastName());
        fillAddress(orderData.getAddress());
        fillSubway(orderData.getSubway());
        fillPhone(orderData.getPhone());
        pressContinue();
        fillRentDate(orderData.getRentDay());
        fillRentDuration(orderData.getRentDuration());
        fillColor(orderData.getColor());
        submitOrder();
        return driver.findElement(successHeader).getText();
    }

    private void fillFirstName(String firstName) {
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(firstNameField).isEnabled());
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    private void fillLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    private void fillAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    private void fillSubway(String subway) {
        driver.findElement(subwayField).click();
        new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(By.xpath("//ul[@class = 'select-search__options']")).isDisplayed());
        driver.findElement(By.xpath("//div[text() = '" + subway + "']//parent::button")).click();
    }

    private void fillPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    private void pressContinue() {
        driver.findElement(continueButton).click();
    }

    private void fillRentDate(String rentDay) {
        new WebDriverWait(driver, 3)
                .until(driver -> driver.findElement(rentDateField).isEnabled());
        driver.findElement(rentDateField).click();
        driver.findElement(By.xpath("//div[@class = 'react-datepicker__day react-datepicker__day--0" + rentDay + "']")).click();
    }

    private void fillRentDuration(String rentDuration) {
        driver.findElement(rentDurationField).click();
        driver.findElement(By.xpath("//div[@role = 'option' and text() = '" + rentDuration + "']")).click();
    }

    private void fillColor(String color) {
        driver.findElement(By.xpath("//label[@for = '" + color + "']")).click();
    }

    private void submitOrder() {
        driver.findElement(submitButton).click();
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(confirmButton).isEnabled());
        driver.findElement(confirmButton).click();
        new WebDriverWait(driver, 3).until(driver -> driver.findElement(successHeader).isDisplayed());
    }

    public void clickStatusButton() {
        driver.findElement(watchStatus).click();
    }
}