package ru.merkel.examinerservice.services;

import org.springframework.web.server.MethodNotAllowedException;
import ru.merkel.examinerservice.models.Question;

import java.util.Collection;
import java.util.Scanner;

public interface QuestionService {
    Question add(String question, String answer) throws MethodNotAllowedException;

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> removeAll();

    Collection<Question> getAll();

    Question getRandomQuestion();
}
