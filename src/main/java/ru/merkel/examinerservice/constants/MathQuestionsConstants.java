package ru.merkel.examinerservice.constants;

import ru.merkel.examinerservice.models.Question;

import java.util.List;

public class MathQuestionsConstants {
    public static final String MATH_QUESTION_1 = "Джун написал 17 тестов, и все, кроме 9 упали. Сколько тестов оказались успешными?";
    public static final String MATH_QUESTION_2 = "Сколько яиц сможет съесть джун натощак?";
    public static final String MATH_QUESTION_3 = "3 джуна работали над проектом 12 часов. Сколько времени работал над проектом каждый из них?";
    public static final String MATH_QUESTION_4 = "Сколько нужно поставить знаков «плюс» (+) между цифрами числа 987 654 321, чтобы в сумме получилось 99?";
    public static final String MATH_QUESTION_5 = "Часы со стрелками отстают на 6 минут каждый день. Через сколько дней они опять будут показывать верное время?";

    public static final String MATH_ANSWER_1 = "9";
    public static final String MATH_ANSWER_2 = "1";
    public static final String MATH_ANSWER_3 = "12";
    public static final String MATH_ANSWER_4 = "9 + 8 + 7 + 65 + 4 + 3 + 2 + 1 = 99";
    public static final String MATH_ANSWER_5 = "Через 120 дней";

    public static final Question MATH_OBJECT_QUESTION_1 = new Question(MATH_QUESTION_1, MATH_ANSWER_1);
    public static final Question MATH_OBJECT_QUESTION_2 = new Question(MATH_QUESTION_2, MATH_ANSWER_2);
    public static final Question MATH_OBJECT_QUESTION_3 = new Question(MATH_QUESTION_3, MATH_ANSWER_3);
    public static final Question MATH_OBJECT_QUESTION_4 = new Question(MATH_QUESTION_4, MATH_ANSWER_4);
    public static final Question MATH_OBJECT_QUESTION_5 = new Question(MATH_QUESTION_5, MATH_ANSWER_5);

    public static final List<Question> MATH_QUESTIONS = List.of(MATH_OBJECT_QUESTION_1, MATH_OBJECT_QUESTION_2, MATH_OBJECT_QUESTION_3);
}
