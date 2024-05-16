package ru.merkel.examinerservice.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;
import static ru.merkel.examinerservice.constants.JavaQuestionsConstants.*;
import static ru.merkel.examinerservice.constants.MathQuestionsConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestionsTest() {
        when(javaQuestionService.getAll()).thenReturn(JAVA_QUESTIONS);
        when(javaQuestionService.getRandomQuestion()).thenReturn(JAVA_OBJECT_QUESTION_1, JAVA_OBJECT_QUESTION_3, JAVA_OBJECT_QUESTION_5);
        when(mathQuestionService.getAll()).thenReturn(MATH_QUESTIONS);
        when(mathQuestionService.getRandomQuestion()).thenReturn(MATH_OBJECT_QUESTION_3, MATH_OBJECT_QUESTION_1);
        Collection<Question> actual = examinerService.getQuestions(5);
        assertThat(actual, hasItems(JAVA_OBJECT_QUESTION_1, JAVA_OBJECT_QUESTION_3, JAVA_OBJECT_QUESTION_5, MATH_OBJECT_QUESTION_3, MATH_OBJECT_QUESTION_1));
    }

    @Test
    void shouldReturnNotFoundException() {
        assertThrows(QuestionNotFoundException.class, () -> examinerService.getQuestions(2));
    }
}