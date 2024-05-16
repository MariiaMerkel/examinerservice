package ru.merkel.examinerservice.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final Random random;

    public MathQuestionService() {
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) throws MethodNotAllowedException {
        throw new UnsupportedOperationException("Эта функция не поддерживается");
    }

    @Override
    public Question add(Question question) {
        throw new UnsupportedOperationException("Эта функция не поддерживается");
    }

    @Override
    public Question remove(Question question) {
        throw new UnsupportedOperationException("Эта функция не поддерживается");
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException("Эта функция не поддерживается");
    }

    @Override
    public Collection<Question> getAll() {
        throw new UnsupportedOperationException("Эта функция не поддерживается");
    }

    @Override
    public Question getRandomQuestion() {
        int first = getRandomInt(-10, 11);
        int last = getRandomInt(-10, 11);
        int act = getRandomInt(1, 5);
        StringBuilder question = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        switch (act) {
            case 1:
                question.append(String.format("%d + %d = ?", first, last));
                answer.append(String.format("%d + %d = %d", first, last, first + last));
                break;
            case 2:
                question.append(String.format("%d - %d = ?", first, last));
                answer.append(String.format("%d - %d = %d", first, last, first - last));
                break;

            case 3:
                question.append(String.format("%d * %d = ?", first, last));
                answer.append(String.format("%d * %d = %d", first, last, first * last));
                break;

            case 4:
                if (last != 0) {
                    question.append(String.format("%d / %d = ?", first, last));
                    answer.append(String.format("%d / %d = %d", first, last, first / last));
                } else {
                    last++;
                    question.append(String.format("%d / %d = ?", first, last));
                    answer.append(String.format("%d / %d = %d", first, last, first / last));
                }
                break;
        }
        return new Question(question.toString(), answer.toString());
    }

    public int getRandomInt(int origin, int bound) {
        return random.nextInt(origin, bound);
    }
}