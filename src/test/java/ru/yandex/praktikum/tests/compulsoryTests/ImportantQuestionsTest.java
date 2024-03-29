package ru.yandex.praktikum.tests.compulsoryTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.tests.pageObjects.ImportantQuestionsObject;
import ru.yandex.praktikum.tests.pageObjects.MainPageObject;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.tests.WebDriverConfiguration.setDriver;
import static ru.yandex.praktikum.tests.constants.Answer.*;
import static ru.yandex.praktikum.tests.constants.TestConstants.SCOOTER_MAIN_PAGE_URL;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.CHROME;
import static ru.yandex.praktikum.tests.constants.TestConstants.WebDriverType.FIREFOX;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest {

    private WebDriver driver;
    private final String questionIndex;
    private final String checkedAnswer;
    private final WebDriverType driverType;

    public ImportantQuestionsTest(String questionIndex, String checkedAnswer, WebDriverType driverType) {
        this.questionIndex = questionIndex;
        this.checkedAnswer = checkedAnswer;
        this.driverType = driverType;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswers() {
        return new Object[][]{
                {ANSWER_O.getIndex(), ANSWER_O.getAnswer(), CHROME},
                {ANSWER_1.getIndex(), ANSWER_1.getAnswer(), CHROME},
                {ANSWER_2.getIndex(), ANSWER_2.getAnswer(), CHROME},
                {ANSWER_3.getIndex(), ANSWER_3.getAnswer(), CHROME},
                {ANSWER_4.getIndex(), ANSWER_4.getAnswer(), FIREFOX},
                {ANSWER_5.getIndex(), ANSWER_5.getAnswer(), FIREFOX},
                {ANSWER_6.getIndex(), ANSWER_6.getAnswer(), FIREFOX},
                {ANSWER_7.getIndex(), ANSWER_7.getAnswer(), FIREFOX},
        };
    }


    @Before
    public void startUp() {
        driver = setDriver(driverType);
        driver.get(SCOOTER_MAIN_PAGE_URL);
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.confirmCookies();
    }

    @After
    public void closeSession() {
        driver.quit();
    }

    @Test
    public void shouldOpenCorrectAnswer() {
        ImportantQuestionsObject iQObj = new ImportantQuestionsObject(driver);
        String actualAnswer = iQObj.getImportantQuestionsAnswerByIndex(questionIndex);
        assertEquals("Answers should be equals", checkedAnswer, actualAnswer);
    }
}