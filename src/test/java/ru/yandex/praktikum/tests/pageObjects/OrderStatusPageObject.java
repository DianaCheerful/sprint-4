package ru.yandex.praktikum.tests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPageObject {

    private final WebDriver driver;
    private final By notFoundPicture = By.xpath("//*[@alt='Not found']");


    public OrderStatusPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNotFound() {
        return driver.findElement(notFoundPicture).isDisplayed();
    }
}