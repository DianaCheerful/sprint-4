package ru.yandex.praktikum.tests.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ImportantQuestionsObject {

    private final WebDriver driver;
    private final By importantQuestionsHeader = By.xpath("//div[text()= 'Вопросы о важном']");

    public ImportantQuestionsObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getImportantQuestionsAnswerByIndex(String questionIndex) {
        By importantQuestion = By.id("accordion__heading-" + questionIndex);
        By importantAnswer = By.id("accordion__panel-" + questionIndex);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", driver.findElement(importantQuestionsHeader));

        driver.findElement(importantQuestion).click();

        new WebDriverWait(driver, 3)
                .until(driver -> (driver.findElement(importantAnswer).isDisplayed()));

        return driver.findElement(importantAnswer).getText();
    }
}