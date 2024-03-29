package ru.yandex.praktikum.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ru.yandex.praktikum.tests.constants.TestConstants.*;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.CHROME;

public class WebDriverConfiguration {

    public static WebDriver setDriver(WebDriverType webDriver) {
        if (webDriver == CHROME) {
            return setChrome();
        } else {
            return setFirefox();
        }
    }

    private static ChromeDriver setChrome() {
        WebDriverManager.chromedriver().setup();
        System.setProperty(CHROME_DRIVER_PARAM, CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    private static FirefoxDriver setFirefox() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FIREFOX_DRIVER_PARAM, FIREFOX_DRIVER_PATH);
        return new FirefoxDriver();
    }
}