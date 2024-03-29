package ru.yandex.praktikum.tests.additionalTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.tests.pageObjects.MainPageObject;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.tests.WebDriverConfiguration.setDriver;
import static ru.yandex.praktikum.tests.constants.TestConstants.*;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.CHROME;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.FIREFOX;

@RunWith(Parameterized.class)
public class LogoTest {
    private WebDriver driver;
    private MainPageObject mainPageObject;
    private final WebDriverType driverType;

    public LogoTest(WebDriverType driverType) {
        this.driverType = driverType;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {CHROME},
                {FIREFOX},
        };
    }

    @Before
    public void startUp() {
        driver = setDriver(driverType);
        driver.get(SCOOTER_ORDER_PAGE_URL);
        mainPageObject = new MainPageObject(driver);
        mainPageObject.confirmCookies();
    }

    @After
    public void closeSession() {
        driver.quit();
    }

    @Test
    public void shouldOpenMainPage() {
        mainPageObject.clickLogoScooter();
        assertEquals("Pages urls should be the same", SCOOTER_MAIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    public void shouldOpenYandexPage() {
        mainPageObject.clickLogoYandex();
        assertEquals("Pages urls should be the same", YANDEX_PAGE_URL, driver.getCurrentUrl());
    }
}