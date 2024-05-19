package ru.merkel.examinerservice.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.merkel.examinerservice.models.Question;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    private MathQuestionService mathQuestionService;
    private Random randomMock;

    @BeforeEach
    void setUp() {
        randomMock = Mockito.mock(Random.class);
        mathQuestionService = new MathQuestionService(randomMock);
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
    void removeAllTest() {
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionService.removeAll());
    }

    @Test
    void shouldReturnAlQuestions() {
        assertThrows(UnsupportedOperationException.class, () -> mathQuestionService.getAll());
    }

    @Test
    void RandomQuestionWithSumTest() {
        when(randomMock.nextInt(-10, 11)).thenReturn(1).thenReturn(2);
        when(randomMock.nextInt(1, 5)).thenReturn(1);

        MathQuestionService mathQuestionService = new MathQuestionService(randomMock);

        Question actual = mathQuestionService.getRandomQuestion();
        Question expected = new Question("1 + 2 = ?", "1 + 2 = 3");

        assertEquals(expected, actual);

    }

    @Test
    void RandomQuestionWithSubtractionTest() {

        when(randomMock.nextInt(-10, 11))
                .thenReturn(3)
                .thenReturn(4);

        when(randomMock.nextInt(1, 5))
                .thenReturn(2);

        Question actual = mathQuestionService.getRandomQuestion();

        assertEquals(new Question("3 - 4 = ?", "3 - 4 = -1"), actual);

    }

    @Test
    void RandomQuestionWithsMultiplyTest() {

        when(randomMock.nextInt(-10, 11))
                .thenReturn(5)
                .thenReturn(6);

        when(randomMock.nextInt(1, 5))
                .thenReturn(3);

        Question actual = mathQuestionService.getRandomQuestion();

        assertEquals(new Question("5 * 6 = ?", "5 * 6 = 30"), actual);

    }

    @Test
    void RandomQuestionWithDivedTest() {

        when(randomMock.nextInt(-10, 11))
                .thenReturn(7)
                .thenReturn(8)
                .thenReturn(9)
                .thenReturn(0)
                .thenReturn(11);

        when(randomMock.nextInt(1, 5))
                .thenReturn(4);

        Question actual1 = mathQuestionService.getRandomQuestion();
        Question actual2 = mathQuestionService.getRandomQuestion();
        Question actual3 = mathQuestionService.getRandomQuestion();

        assertEquals(new Question("7 / 8 = ?", "7 / 8 = 0,875"), actual1);
        assertEquals(new Question("9 / 1 = ?", "9 / 1 = 9"), actual2);
        assertEquals(new Question("11 / 11 = ?", "11 / 11 = 1"), actual3);

    }
}