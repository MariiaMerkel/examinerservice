package ru.merkel.examinerservice.services.impl;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.merkel.examinerservice.exceptions.QuestionAlreadyAddedException;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.repositiories.impl.MathQuestionRepository;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.merkel.examinerservice.constants.MathQuestionsConstants.*;

class MathQuestionServiceTest {

    public QuestionService mathQuestionService = new MathQuestionService(new MathQuestionRepository());

    @BeforeEach
    public void setUp() {
        mathQuestionService.add(MATH_QUESTION_1, MATH_ANSWER_1);
        mathQuestionService.add(MATH_QUESTION_2, MATH_ANSWER_2);
        mathQuestionService.add(MATH_QUESTION_3, MATH_ANSWER_3);
    }

    @Test
    void shouldReturnAddedQuestion() {
        Question actual = mathQuestionService.add(MATH_QUESTION_4, MATH_ANSWER_4);
        Question actual2 = mathQuestionService.add(MATH_OBJECT_QUESTION_5);
        assertEquals(MATH_OBJECT_QUESTION_4, actual);
        assertEquals(MATH_OBJECT_QUESTION_5, actual2);
    }

    @Test
    void shouldReturnAlreadyAddedException() {
        assertThrows(QuestionAlreadyAddedException.class, () -> mathQuestionService.add(MATH_QUESTION_1, MATH_ANSWER_1));
        assertThrows(QuestionAlreadyAddedException.class, () -> mathQuestionService.add(MATH_OBJECT_QUESTION_2));
    }

    @Test
    void shouldReturnRandomQuestion() {
        Question actual = mathQuestionService.getRandomQuestion();
        assertThat(MATH_QUESTIONS, hasItems(actual));
    }

    @Test
    void shouldThrowNotFoundException() {
        mathQuestionService.removeAll();
        assertThrows(QuestionNotFoundException.class, () -> mathQuestionService.getRandomQuestion());
    }

    @Test
    void shouldReturnRemovedQuestion() {
        Question actual = mathQuestionService.remove(MATH_OBJECT_QUESTION_1);
        assertEquals(MATH_OBJECT_QUESTION_1, actual);
        assertThrows(QuestionNotFoundException.class, () -> mathQuestionService.remove(MATH_OBJECT_QUESTION_1));
    }

    @Test
    void shouldReturnAlQuestions() {
        Collection<Question> actual = mathQuestionService.getAll();
        assertThat(actual, Matchers.containsInAnyOrder(
                MATH_OBJECT_QUESTION_1,
                MATH_OBJECT_QUESTION_2,
                MATH_OBJECT_QUESTION_3
        ));
    }
}