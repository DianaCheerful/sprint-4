package ru.yandex.praktikum.tests.compulsoryTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.tests.pageObjects.MainPageObject;
import ru.yandex.praktikum.tests.pageObjects.OrderPageObject;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.tests.WebDriverConfiguration.setDriver;
import static ru.yandex.praktikum.tests.constants.TestConstants.*;
import static ru.yandex.praktikum.tests.constants.TestConstants.OrderButtonPosition.DOWN;
import static ru.yandex.praktikum.tests.constants.TestConstants.OrderButtonPosition.UP;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.CHROME;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.FIREFOX;

@RunWith(Parameterized.class)
public class OrderCreatingTest {
    private WebDriver driver;
    private MainPageObject mainPageObject;
    private OrderPageObject orderPageObject;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String subway;
    private final String phone;
    private final String rentDay;
    private final String rentDuration;
    private final String color;
    private final OrderButtonPosition buttonPosition;
    private final WebDriverType driverType;

    public OrderCreatingTest(
            String firstName,
            String lastName,
            String address,
            String subway,
            String phone,
            String rentDay,
            String rentDuration,
            String color,
            OrderButtonPosition buttonPosition,
            WebDriverType driverType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.subway = subway;
        this.phone = phone;
        this.rentDay = rentDay;
        this.rentDuration = rentDuration;
        this.color = color;
        this.buttonPosition = buttonPosition;
        this.driverType = driverType;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {FIRST_NAME_1, LAST_NAME_1, ADDRESS_1, SUBWAY_1, PHONE_1, RENT_DAY, RENT_DURATION_1, BLACK_COLOR, UP, CHROME},
                {FIRST_NAME_2, LAST_NAME_2, ADDRESS_2, SUBWAY_2, PHONE_2, RENT_DAY_2, RENT_DURATION_2, GREY_COLOR, DOWN, FIREFOX},
        };
    }

    @Before
    public void openMainPage() {
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
    public void shouldOpenOrderPage() {
        orderPageObject = new OrderPageObject(driver);
        mainPageObject.clickOrderButton(buttonPosition);
        boolean actualVisibility = orderPageObject.isOrderPageOpened();
        assertTrue("Visibility should be true", actualVisibility);
    }

    @Test
    public void shouldCreateOrder() {
        mainPageObject.clickOrderButton(buttonPosition);
        orderPageObject = new OrderPageObject(driver);
        String actualResult = orderPageObject.createOrder(firstName, lastName, address, subway, phone, rentDay, rentDuration, color);
        assertTrue("Should be true", actualResult.startsWith(SUCCESS_ORDER_MESSAGE));
    }
}