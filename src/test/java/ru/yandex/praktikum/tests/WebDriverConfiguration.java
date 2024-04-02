package ru.yandex.praktikum.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.CHROME;

public class WebDriverConfiguration extends ExternalResource {

    public static WebDriver setDriver(WebDriverType webDriver) {
        if (webDriver == CHROME) {
            return setChrome();
        } else {
            return setFirefox();
        }
    }

    private static ChromeDriver setChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(new ChromeOptions());
    }

    private static FirefoxDriver setFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(new FirefoxOptions());
    }
}