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
import static ru.merkel.examinerservice.services.impl.ConstantsForTests.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestionsTest() {
        when(javaQuestionService.getAll()).thenReturn(QUESTIONS);
        when(javaQuestionService.getRandomQuestion()).thenReturn(OBJECT_QUESTION_1, OBJECT_QUESTION_3, OBJECT_QUESTION_5);
        Collection<Question> actual = examinerService.getQuestions(3);
        assertThat(actual, hasItems(OBJECT_QUESTION_1, OBJECT_QUESTION_3, OBJECT_QUESTION_5));
    }

    @Test
    void shouldReturnNotFoundException() {
        assertThrows(QuestionNotFoundException.class, () -> examinerService.getQuestions(2));
    }
}