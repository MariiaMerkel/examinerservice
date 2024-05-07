package ru.merkel.examinerservice.services.impl;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.merkel.examinerservice.exceptions.QuestionAlreadyAddedException;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.merkel.examinerservice.services.impl.ConstantsForTests.*;

class JavaQuestionServiceTest {

    public QuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    public void setUp() {
        javaQuestionService.add(QUESTION_1, ANSWER_1);
        javaQuestionService.add(QUESTION_2, ANSWER_2);
        javaQuestionService.add(QUESTION_3, ANSWER_3);
        javaQuestionService.add(QUESTION_4, ANSWER_4);
        javaQuestionService.add(QUESTION_5, ANSWER_5);
        javaQuestionService.add(QUESTION_6, ANSWER_6);
        javaQuestionService.add(QUESTION_7, ANSWER_7);
        javaQuestionService.add(QUESTION_8, ANSWER_8);
    }

    @Test
    void shouldReturnAddedQuestion() {
        Question expected = new Question(QUESTION_9, ANSWER_9);
        Question expected2 = new Question("Что такое super?", "Это вызов конструктора класса родителя.");
        Question actual = javaQuestionService.add(QUESTION_9, ANSWER_9);
        Question actual2 = javaQuestionService.add(expected2);
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    void shouldReturnAlreadyAddedException() {
        assertThrows(QuestionAlreadyAddedException.class, () -> javaQuestionService.add(QUESTION_1, ANSWER_1));
        assertThrows(QuestionAlreadyAddedException.class, () -> javaQuestionService.add(OBJECT_QUESTION_1));
    }

    @Test
    void shouldReturnRandomQuestion() {
        Question actual = javaQuestionService.getRandomQuestion();
        assertThat(QUESTIONS, hasItems(actual));
    }

    @Test
    void shouldReturnRemovedQuestion() {
        Question expected = new Question(QUESTION_1, ANSWER_1);
        Question actual = javaQuestionService.remove(OBJECT_QUESTION_1);
        assertEquals(expected, actual);
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(OBJECT_QUESTION_1));
    }

    @Test
    void shouldReturnAlQuestions() {
        Collection<Question> actual = javaQuestionService.getAll();
        assertThat(actual, Matchers.containsInAnyOrder(
                OBJECT_QUESTION_1,
                OBJECT_QUESTION_2,
                OBJECT_QUESTION_3,
                OBJECT_QUESTION_4,
                OBJECT_QUESTION_5,
                OBJECT_QUESTION_6,
                OBJECT_QUESTION_7,
                OBJECT_QUESTION_8
        ));
    }
}