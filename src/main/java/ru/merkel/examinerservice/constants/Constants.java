package ru.merkel.examinerservice.constants;

import ru.merkel.examinerservice.models.Question;

import java.util.List;

public class Constants {
    public static final String QUESTION_1 = "Зачем придумали язык Java?";
    public static final String QUESTION_2 = "Что значит, что JAVA компилируемый язык?";
    public static final String QUESTION_3 = "Что такое JVM?";
    public static final String QUESTION_4 = "Что такое JDK?";
    public static final String QUESTION_5 = "Какая связь ByteCode с JVM?";
    public static final String QUESTION_6 = "Что такое Boxing?";
    public static final String QUESTION_7 = "Что такое Unboxing?";
    public static final String QUESTION_8 = "Что такое полиморфизм?";
    public static final String QUESTION_9 = "Что такое SOLID?";
    public static final String ANSWER_1 = "чтобы новый язык программирования был максимально универсальным и человекочитаемый.";
    public static final String ANSWER_2 = "Java компилируется сначала в байткод, а затем она уже интерпретирует его в машинный код конкретной вычислительной машины, которая интерпретируется непосредственно процессором или микропрограммами этой вычислительной машины.";
    public static final String ANSWER_3 = "Это виртуальная машина Java.";
    public static final String ANSWER_4 = "Это комплект для разработки на Java.";
    public static final String ANSWER_5 = "JVM обеспечивает работу байт-кода Java, что позволяет Java быть платформо-независимым языком, так как JVM присутствует на всех основных операционных системах.";
    public static final String ANSWER_6 = "Это автоматическая инкапсуляция примитивного типа в эквивалентную ему класс-обёртку всякий раз, когда требуется объект данного типа.";
    public static final String ANSWER_7 = "Это преобразование класса-обёртки в соответствующий ему примитивный тип.";
    public static final String ANSWER_8 = "это способность программы идентично использовать объекты с одинаковым интерфейсом без информации о конкретном типе этого объекта.";
    public static final String ANSWER_9 = "это принципы разработки программного обеспечения, следуя которым Вы получите хороший код, который в дальнейшем будет хорошо масштабироваться и поддерживаться в рабочем состоянии.";
    public static final Question OBJECT_QUESTION_1 = new Question(QUESTION_1, ANSWER_1);
    public static final Question OBJECT_QUESTION_2 = new Question(QUESTION_2, ANSWER_2);
    public static final Question OBJECT_QUESTION_3 = new Question(QUESTION_3, ANSWER_3);
    public static final Question OBJECT_QUESTION_4 = new Question(QUESTION_4, ANSWER_4);
    public static final Question OBJECT_QUESTION_5 = new Question(QUESTION_5, ANSWER_5);
    public static final Question OBJECT_QUESTION_6 = new Question(QUESTION_6, ANSWER_6);
    public static final Question OBJECT_QUESTION_7 = new Question(QUESTION_7, ANSWER_7);
    public static final Question OBJECT_QUESTION_8 = new Question(QUESTION_8, ANSWER_8);
    public static final List<Question> JAVA_QUESTIONS = List.of(OBJECT_QUESTION_1, OBJECT_QUESTION_2, OBJECT_QUESTION_3, OBJECT_QUESTION_4, OBJECT_QUESTION_5, OBJECT_QUESTION_6, OBJECT_QUESTION_7, OBJECT_QUESTION_8);

    public static final String MATH_QUESTION_1 = "Джун написал 17 тестов, и все, кроме 9 упали. Сколько тестов оказались успешными?";
    public static final String MATH_QUESTION_2 = "Сколько яиц сможет съесть джун натощак?";
    public static final String MATH_QUESTION_3 = "3 джуна работали над проектом 12 часов. Сколько времени работал над проектом каждый из них?";
        public static final String MATH_ANSWER_1 = "9";
    public static final String MATH_ANSWER_2 = "1";
    public static final String MATH_ANSWER_3 = "12";
    public static final List<Question> MATH_QUESTIONS = List.of(OBJECT_QUESTION_1, OBJECT_QUESTION_2, OBJECT_QUESTION_3);
}
