package ru.merkel.examinerservice.repositiories;

import ru.merkel.examinerservice.models.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    void removeAll();

    Collection<Question> getAll();
}
