package ru.yandex.praktikum.tests.additionalTests;

import org.junit.Test;
import ru.yandex.praktikum.tests.BaseTest;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.tests.constants.TestConstants.SCOOTER_MAIN_PAGE_URL;
import static ru.yandex.praktikum.tests.constants.TestConstants.YANDEX_PAGE_URL;

public class LogoTest extends BaseTest {

    @Test
    public void shouldOpenMainPage() {
        mainPageObject.clickLogoScooter();
        assertEquals("Pages urls should be the same", SCOOTER_MAIN_PAGE_URL, getWebdriver().getCurrentUrl());
    }

    @Test
    public void shouldOpenYandexPage() {
        mainPageObject.clickLogoYandex();
        assertEquals("Pages urls should be the same", YANDEX_PAGE_URL, getWebdriver().getCurrentUrl());
    }
}