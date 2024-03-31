package ru.yandex.praktikum.tests.compulsoryTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.tests.CommonTestService;
import ru.yandex.praktikum.tests.constants.OrderData;
import ru.yandex.praktikum.tests.pageObjects.OrderPageObject;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.tests.constants.OrderData.ORDER_1;
import static ru.yandex.praktikum.tests.constants.OrderData.ORDER_2;
import static ru.yandex.praktikum.tests.constants.TestConstants.OrderButtonPosition;
import static ru.yandex.praktikum.tests.constants.TestConstants.OrderButtonPosition.DOWN;
import static ru.yandex.praktikum.tests.constants.TestConstants.OrderButtonPosition.UP;
import static ru.yandex.praktikum.tests.constants.TestConstants.SUCCESS_ORDER_MESSAGE;

@RunWith(Parameterized.class)
public class OrderCreatingTest extends CommonTestService {

    private OrderPageObject orderPageObject;

    private final OrderData orderData;
    private final OrderButtonPosition buttonPosition;

    public OrderCreatingTest(OrderData orderData, OrderButtonPosition buttonPosition) {
        this.orderData = orderData;
        this.buttonPosition = buttonPosition;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {ORDER_1, UP},
                {ORDER_2, DOWN}
        };
    }

    @Before
    public void init() {
        mainPageObject.clickLogoScooter();

    }

    @After
    public void finish() {
        orderPageObject.clickStatusButton();
    }

    @Test
    public void shouldCreateOrder() {
        mainPageObject.clickOrderButton(buttonPosition);
        orderPageObject = new OrderPageObject(getWebdriver());
        String actualResult =
                orderPageObject.createOrder(orderData);
        assertTrue("Should be true", actualResult.startsWith(SUCCESS_ORDER_MESSAGE));
    }
}