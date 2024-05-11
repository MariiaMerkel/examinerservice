package ru.merkel.examinerservice.services;

import ru.merkel.examinerservice.models.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
