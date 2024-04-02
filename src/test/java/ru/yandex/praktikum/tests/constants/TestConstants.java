package ru.yandex.praktikum.tests.constants;

public class TestConstants {

    public static final String SCOOTER_MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String YANDEX_PAGE_URL = "https://dzen.ru/?yredirect=true";

    public static final String ORDER_NUMBER_1 = "79765";
    public static final String ORDER_NUMBER_2 = "678953";


    public enum OrderButtonPosition {
        UP,
        DOWN
    }

    public enum WebDriverType {
        CHROME,
        FIREFOX
    }

    public static final String SUCCESS_ORDER_MESSAGE = "Заказ оформлен";
}