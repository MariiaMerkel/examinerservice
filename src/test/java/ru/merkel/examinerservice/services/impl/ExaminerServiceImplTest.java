package ru.merkel.examinerservice.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static ru.merkel.examinerservice.constants.JavaQuestionsConstants.*;

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
        when(javaQuestionService.getRandomQuestion()).thenReturn(JAVA_OBJECT_QUESTION_1, JAVA_OBJECT_QUESTION_3, JAVA_OBJECT_QUESTION_5);
        Question expected1 = new Question("1 + 2 = ?", "1 + 2 = 3");
        Question expected2 = new Question("3 - 4 = ?", "3 - 4 = -1");

        when(mathQuestionService.getRandomQuestion()).thenReturn(expected1, expected2);
        Collection<Question> actual = examinerService.getQuestions(5);
        assertThat(actual, hasItems(JAVA_OBJECT_QUESTION_1, JAVA_OBJECT_QUESTION_3, JAVA_OBJECT_QUESTION_5, expected1, expected2));
    }

    @Test
    void shouldReturnNotFoundException() {
        when(javaQuestionService.getRandomQuestion()).thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class, () -> examinerService.getQuestions(2));
    }
}