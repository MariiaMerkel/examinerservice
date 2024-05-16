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
import ru.merkel.examinerservice.repositiories.impl.MathQuestionRepository;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static ru.merkel.examinerservice.constants.MathQuestionsConstants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    public MathQuestionRepository mathQuestionRepository;

    @InjectMocks
    public MathQuestionService mathQuestionService;

    @Test
    void shouldReturnAddedQuestion() {
        when(mathQuestionRepository.add(MATH_OBJECT_QUESTION_4)).thenReturn(MATH_OBJECT_QUESTION_4);
        when(mathQuestionRepository.add(MATH_OBJECT_QUESTION_5)).thenReturn(MATH_OBJECT_QUESTION_5);
        Question actual = mathQuestionService.add(MATH_QUESTION_4, MATH_ANSWER_4);
        Question actual2 = mathQuestionService.add(MATH_OBJECT_QUESTION_5);
        assertEquals(MATH_OBJECT_QUESTION_4, actual);
        assertEquals(MATH_OBJECT_QUESTION_5, actual2);
    }

    @Test
    void shouldReturnAlreadyAddedException() {
        when(mathQuestionRepository.add(MATH_OBJECT_QUESTION_1)).thenThrow(QuestionAlreadyAddedException.class);
        when(mathQuestionRepository.add(MATH_OBJECT_QUESTION_2)).thenThrow(QuestionAlreadyAddedException.class);
        assertThrows(QuestionAlreadyAddedException.class, () -> mathQuestionService.add(MATH_QUESTION_1, MATH_ANSWER_1));
        assertThrows(QuestionAlreadyAddedException.class, () -> mathQuestionService.add(MATH_OBJECT_QUESTION_2));
    }

    @Test
    void shouldReturnRandomQuestion() {
        when(mathQuestionRepository.getAll()).thenReturn(MATH_QUESTIONS);
        Question actual = mathQuestionService.getRandomQuestion();
        assertThat(MATH_QUESTIONS, hasItems(actual));
    }

    @Test
    void shouldThrowNotFoundException() {
        when(mathQuestionRepository.getAll()).thenReturn(new HashSet<>());
        assertThrows(QuestionNotFoundException.class, () -> mathQuestionService.getRandomQuestion());
    }

    @Test
    void shouldReturnRemovedQuestion() {
        when(mathQuestionRepository.remove(MATH_OBJECT_QUESTION_1)).thenReturn(MATH_OBJECT_QUESTION_1);
        when(mathQuestionRepository.remove(MATH_OBJECT_QUESTION_2)).thenThrow(QuestionNotFoundException.class);
        Question actual = mathQuestionService.remove(MATH_OBJECT_QUESTION_1);
        assertEquals(MATH_OBJECT_QUESTION_1, actual);
        assertThrows(QuestionNotFoundException.class, () -> mathQuestionService.remove(MATH_OBJECT_QUESTION_2));
    }

    @Test
    void shouldReturnAlQuestions() {
        when(mathQuestionRepository.getAll()).thenReturn(MATH_QUESTIONS);
        Collection<Question> actual = mathQuestionService.getAll();
        assertThat(actual, Matchers.containsInAnyOrder(
                MATH_OBJECT_QUESTION_1,
                MATH_OBJECT_QUESTION_2,
                MATH_OBJECT_QUESTION_3
        ));
    }
}