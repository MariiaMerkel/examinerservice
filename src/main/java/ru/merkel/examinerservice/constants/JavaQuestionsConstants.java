package ru.merkel.examinerservice.constants;

import ru.merkel.examinerservice.models.Question;

import java.util.List;

public class JavaQuestionsConstants {
    public static final String JAVA_QUESTION_1 = "Зачем придумали язык Java?";
    public static final String JAVA_QUESTION_2 = "Что значит, что JAVA компилируемый язык?";
    public static final String JAVA_QUESTION_3 = "Что такое JVM?";
    public static final String JAVA_QUESTION_4 = "Что такое JDK?";
    public static final String JAVA_QUESTION_5 = "Какая связь ByteCode с JVM?";
    public static final String JAVA_QUESTION_6 = "Что такое Boxing?";
    public static final String JAVA_QUESTION_7 = "Что такое Unboxing?";
    public static final String JAVA_QUESTION_8 = "Что такое полиморфизм?";
    public static final String JAVA_QUESTION_9 = "Что такое SOLID?";
    public static final String JAVA_QUESTION_10 = "Что такое super?";

    public static final String JAVA_ANSWER_1 = "чтобы новый язык программирования был максимально универсальным и человекочитаемый.";
    public static final String JAVA_ANSWER_2 = "Java компилируется сначала в байткод, а затем она уже интерпретирует его в машинный код конкретной вычислительной машины, которая интерпретируется непосредственно процессором или микропрограммами этой вычислительной машины.";
    public static final String JAVA_ANSWER_3 = "Это виртуальная машина Java.";
    public static final String JAVA_ANSWER_4 = "Это комплект для разработки на Java.";
    public static final String JAVA_ANSWER_5 = "JVM обеспечивает работу байт-кода Java, что позволяет Java быть платформо-независимым языком, так как JVM присутствует на всех основных операционных системах.";
    public static final String JAVA_ANSWER_6 = "Это автоматическая инкапсуляция примитивного типа в эквивалентную ему класс-обёртку всякий раз, когда требуется объект данного типа.";
    public static final String JAVA_ANSWER_7 = "Это преобразование класса-обёртки в соответствующий ему примитивный тип.";
    public static final String JAVA_ANSWER_8 = "это способность программы идентично использовать объекты с одинаковым интерфейсом без информации о конкретном типе этого объекта.";
    public static final String JAVA_ANSWER_9 = "это принципы разработки программного обеспечения, следуя которым Вы получите хороший код, который в дальнейшем будет хорошо масштабироваться и поддерживаться в рабочем состоянии.";
    public static final String JAVA_ANSWER_10 = "Это вызов конструктора класса родителя.";

    public static final Question JAVA_OBJECT_QUESTION_1 = new Question(JAVA_QUESTION_1, JAVA_ANSWER_1);
    public static final Question JAVA_OBJECT_QUESTION_2 = new Question(JAVA_QUESTION_2, JAVA_ANSWER_2);
    public static final Question JAVA_OBJECT_QUESTION_3 = new Question(JAVA_QUESTION_3, JAVA_ANSWER_3);
    public static final Question JAVA_OBJECT_QUESTION_4 = new Question(JAVA_QUESTION_4, JAVA_ANSWER_4);
    public static final Question JAVA_OBJECT_QUESTION_5 = new Question(JAVA_QUESTION_5, JAVA_ANSWER_5);
    public static final Question JAVA_OBJECT_QUESTION_6 = new Question(JAVA_QUESTION_6, JAVA_ANSWER_6);
    public static final Question JAVA_OBJECT_QUESTION_7 = new Question(JAVA_QUESTION_7, JAVA_ANSWER_7);
    public static final Question JAVA_OBJECT_QUESTION_8 = new Question(JAVA_QUESTION_8, JAVA_ANSWER_8);
    public static final Question JAVA_OBJECT_QUESTION_9 = new Question(JAVA_QUESTION_9, JAVA_ANSWER_9);
    public static final Question JAVA_OBJECT_QUESTION_10 = new Question(JAVA_QUESTION_10, JAVA_ANSWER_10);

    public static final List<Question> JAVA_QUESTIONS = List.of(JAVA_OBJECT_QUESTION_1, JAVA_OBJECT_QUESTION_2, JAVA_OBJECT_QUESTION_3, JAVA_OBJECT_QUESTION_4, JAVA_OBJECT_QUESTION_5, JAVA_OBJECT_QUESTION_6, JAVA_OBJECT_QUESTION_7, JAVA_OBJECT_QUESTION_8);
}
