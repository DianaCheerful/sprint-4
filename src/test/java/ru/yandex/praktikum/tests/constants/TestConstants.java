package ru.yandex.praktikum.tests.constants;

public class TestConstants {

    public static final String CHROME_DRIVER_PARAM = "webdriver.chrome.driver";
    public static final String FIREFOX_DRIVER_PARAM = "webdriver.gecko.driver";
    public static final String CHROME_DRIVER_PATH = "C:\\Webdriver\\bin\\chromedriver-win64\\chromedriver.exe";
    public static final String FIREFOX_DRIVER_PATH = "C:\\Webdriver\\bin\\geckodriver-win64\\geckodriver.exe";

    public static final String SCOOTER_MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String SCOOTER_ORDER_PAGE_URL = "https://qa-scooter.praktikum-services.ru/order";
    public static final String YANDEX_PAGE_URL = "https://dzen.ru/?yredirect=true";

    public static final String ORDER_NUMBER_1 = "79765";
    public static final String ORDER_NUMBER_2 = "678953";

    public static String FIRST_NAME_1 = "Игорь";
    public static String FIRST_NAME_2 = "Алиса";
    public static String LAST_NAME_1 = "Иванов";
    public static String LAST_NAME_2 = "Петрова";
    public static String ADDRESS_1 = "Москва";
    public static String ADDRESS_2 = "Химки";
    public static String SUBWAY_1 = "Бульвар Рокоссовского";
    public static String SUBWAY_2 = "Сокольники";
    public static String PHONE_1 = "89000000003";
    public static String PHONE_2 = "89000008003";
    public static String RENT_DAY = "05";
    public static String RENT_DAY_2 = "14";
    public static String RENT_DURATION_1 = "сутки";
    public static String RENT_DURATION_2 = "трое суток";
    public static String BLACK_COLOR = "black";
    public static String GREY_COLOR = "grey";

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