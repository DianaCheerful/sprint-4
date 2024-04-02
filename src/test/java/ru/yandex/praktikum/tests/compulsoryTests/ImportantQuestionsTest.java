package ru.yandex.praktikum.tests.compulsoryTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.tests.BaseTest;
import ru.yandex.praktikum.tests.objects.ImportantQuestionsObject;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.tests.constants.Answer.*;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BaseTest {

    private final String questionIndex;
    private final String checkedAnswer;

    public ImportantQuestionsTest(String questionIndex, String checkedAnswer) {
        this.questionIndex = questionIndex;
        this.checkedAnswer = checkedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswers() {
        return new Object[][]{
                {ANSWER_O.getIndex(), ANSWER_O.getAnswer()},
                {ANSWER_1.getIndex(), ANSWER_1.getAnswer()},
                {ANSWER_2.getIndex(), ANSWER_2.getAnswer()},
                {ANSWER_3.getIndex(), ANSWER_3.getAnswer()},
                {ANSWER_4.getIndex(), ANSWER_4.getAnswer()},
                {ANSWER_5.getIndex(), ANSWER_5.getAnswer()},
                {ANSWER_6.getIndex(), ANSWER_6.getAnswer()},
                {ANSWER_7.getIndex(), ANSWER_7.getAnswer()},
        };
    }

    @Test
    public void shouldOpenCorrectAnswer() {
        ImportantQuestionsObject questionsObject = new ImportantQuestionsObject(getWebdriver());
        String actualAnswer = questionsObject.getImportantQuestionsAnswerByIndex(questionIndex);
        assertEquals("Answers should be equals", checkedAnswer, actualAnswer);
    }
}