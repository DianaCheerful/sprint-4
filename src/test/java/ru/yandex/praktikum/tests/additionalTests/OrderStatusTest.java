package ru.yandex.praktikum.tests.additionalTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.tests.BaseTest;
import ru.yandex.praktikum.tests.objects.OrderStatusPageObject;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.tests.constants.TestConstants.ORDER_NUMBER_1;
import static ru.yandex.praktikum.tests.constants.TestConstants.ORDER_NUMBER_2;

@RunWith(Parameterized.class)
public class OrderStatusTest extends BaseTest {

    private final String orderNumber;

    public OrderStatusTest(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {ORDER_NUMBER_1},
                {ORDER_NUMBER_2},
        };
    }

    @Test
    public void shouldShowIfOrderIsNotFound() {
        mainPageObject.checkOrderByNumber(orderNumber);
        OrderStatusPageObject statusPageObject = new OrderStatusPageObject(getWebdriver());
        assertTrue("Should return true", statusPageObject.isNotFound());
    }
}