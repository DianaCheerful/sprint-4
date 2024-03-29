package ru.yandex.praktikum.tests.additionalTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.tests.pageObjects.MainPageObject;
import ru.yandex.praktikum.tests.pageObjects.OrderStatusPageObject;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.tests.WebDriverConfiguration.setDriver;
import static ru.yandex.praktikum.tests.constants.TestConstants.*;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.CHROME;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.FIREFOX;

@RunWith(Parameterized.class)
public class OrderStatusTest {

    private WebDriver driver;
    private MainPageObject mainPageObject;

    private final String orderNumber;
    private final WebDriverType driverType;

    public OrderStatusTest(String orderNumber, WebDriverType driverType) {
        this.orderNumber = orderNumber;
        this.driverType = driverType;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {ORDER_NUMBER_1, CHROME},
                {ORDER_NUMBER_2, FIREFOX},
        };
    }

    @Before
    public void startUp() {
        driver = setDriver(driverType);
        driver.get(SCOOTER_MAIN_PAGE_URL);
        mainPageObject = new MainPageObject(driver);
        mainPageObject.confirmCookies();
    }

    @After
    public void closeSession() {
        driver.quit();
    }

    @Test
    public void shouldShowIfOrderIsNotFound() {
        mainPageObject.checkOrderByNumber(orderNumber);
        OrderStatusPageObject statusPageObject = new OrderStatusPageObject(driver);
        assertTrue("Should return true", statusPageObject.isNotFound());
    }
}