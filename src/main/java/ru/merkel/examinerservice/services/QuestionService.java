package ru.merkel.examinerservice.services;

import ru.merkel.examinerservice.models.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    void removeAll();

    Collection<Question> getAll();

    Question getRandomQuestion();

}
