package ru.merkel.examinerservice.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.QuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    public QuestionService mathQuestionService;
    @BeforeEach
    void setUp(){
        mathQuestionService = new MathQuestionService();
    }

    @Test
    void addTest() {
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionService.add("1+1=?", "1+1=2"));
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionService.add(new Question("1+1=?", "1+1=2")));
    }

    @Test
    void removeTest() {
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionService.remove(new Question("1+1=?", "1+1=2")));
    }

    @Test
    void shouldReturnAlQuestions() {
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionService.getAll());
    }

    @Test
    void shouldReturnRandomQuestion() {

        MathQuestionService mocked = mock(MathQuestionService.class, CALLS_REAL_METHODS);
        when(mocked.getRandomInt(-10, 11)).thenReturn(1);
        when(mocked.getRandomInt(1, 4)).thenReturn(1);
        Question actual = mathQuestionService.getRandomQuestion();
        assertEquals(new Question("1+2=?", "1+2=3"), actual);

    }
}