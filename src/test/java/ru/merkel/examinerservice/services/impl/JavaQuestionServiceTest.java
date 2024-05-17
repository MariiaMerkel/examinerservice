package ru.merkel.examinerservice.services.impl;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.merkel.examinerservice.exceptions.QuestionAlreadyAddedException;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.repositiories.impl.JavaQuestionRepository;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;
import static ru.merkel.examinerservice.constants.JavaQuestionsConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    public JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    public JavaQuestionService javaQuestionService;

    @Test
    void shouldReturnAddedQuestion() {
        when(javaQuestionRepository.add(JAVA_OBJECT_QUESTION_9)).thenReturn(JAVA_OBJECT_QUESTION_9);
        when(javaQuestionRepository.add(JAVA_OBJECT_QUESTION_10)).thenReturn(JAVA_OBJECT_QUESTION_10);
        Question actual = javaQuestionService.add(JAVA_QUESTION_9, JAVA_ANSWER_9);
        Question actual2 = javaQuestionService.add(JAVA_OBJECT_QUESTION_10);
        assertEquals(JAVA_OBJECT_QUESTION_9, actual);
        assertEquals(JAVA_OBJECT_QUESTION_10, actual2);
    }

    @Test
    void shouldReturnAlreadyAddedException() {
        when(javaQuestionRepository.add(JAVA_OBJECT_QUESTION_1)).thenThrow(QuestionAlreadyAddedException.class);
        assertThrows(QuestionAlreadyAddedException.class, () -> javaQuestionService.add(JAVA_QUESTION_1, JAVA_ANSWER_1));
        assertThrows(QuestionAlreadyAddedException.class, () -> javaQuestionService.add(JAVA_OBJECT_QUESTION_1));
    }

    @Test
    void shouldReturnRandomQuestion() {
        when(javaQuestionRepository.getAll()).thenReturn(JAVA_QUESTIONS);
        Question actual = javaQuestionService.getRandomQuestion();
        assertThat(JAVA_QUESTIONS, hasItems(actual));
    }

    @Test
    void shouldThrowNotFoundException() {
        when(javaQuestionRepository.getAll()).thenReturn(new HashSet<>());
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.getRandomQuestion());
    }

    @Test
    void shouldReturnRemovedQuestion() {
        when(javaQuestionRepository.remove(JAVA_OBJECT_QUESTION_1)).thenReturn(JAVA_OBJECT_QUESTION_1);
        when(javaQuestionRepository.remove(JAVA_OBJECT_QUESTION_2)).thenThrow(QuestionNotFoundException.class);
        Question actual = javaQuestionService.remove(JAVA_OBJECT_QUESTION_1);
        assertEquals(JAVA_OBJECT_QUESTION_1, actual);
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(JAVA_OBJECT_QUESTION_2));
    }

    @Test
    void removeAllTest() {
        when(javaQuestionRepository.getAll()).thenReturn(JAVA_QUESTIONS);
        when(javaQuestionRepository.getQuestions()).thenReturn(new HashSet<>(JAVA_QUESTIONS)).thenReturn(new HashSet<>());
        doCallRealMethod().when(javaQuestionRepository).removeAll();

        javaQuestionService.removeAll();

        assertFalse(javaQuestionService.getAll().isEmpty());
    }

    @Test
    void shouldReturnAlQuestions() {
        when(javaQuestionRepository.getAll()).thenReturn(JAVA_QUESTIONS);
        Collection<Question> actual = javaQuestionService.getAll();
        assertThat(actual, Matchers.containsInAnyOrder(
                JAVA_OBJECT_QUESTION_1,
                JAVA_OBJECT_QUESTION_2,
                JAVA_OBJECT_QUESTION_3,
                JAVA_OBJECT_QUESTION_4,
                JAVA_OBJECT_QUESTION_5,
                JAVA_OBJECT_QUESTION_6,
                JAVA_OBJECT_QUESTION_7,
                JAVA_OBJECT_QUESTION_8
        ));
    }
}