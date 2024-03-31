package ru.yandex.praktikum.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.tests.pageObjects.MainPageObject;

import static ru.yandex.praktikum.tests.WebDriverConfiguration.setDriver;
import static ru.yandex.praktikum.tests.constants.TestConstants.SCOOTER_MAIN_PAGE_URL;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.FIREFOX;

public class CommonTestService {

    private static WebDriver driver;
    protected static MainPageObject mainPageObject;

    public static WebDriver getWebdriver() {
        return driver;
    }

    @BeforeClass
    public static void initSettings() {
        driver = setDriver(FIREFOX);
        driver.get(SCOOTER_MAIN_PAGE_URL);
        mainPageObject = new MainPageObject(driver);
        mainPageObject.confirmCookies();
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }
}