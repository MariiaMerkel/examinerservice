package ru.merkel.examinerservice.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.QuestionService;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private Random random;

    public MathQuestionService() {
        this.random = new Random();
    }

    public MathQuestionService(Random random) {
        this.random = random;
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
    public Collection<Question> removeAll() {
        throw new UnsupportedOperationException("Эта функция не поддерживается");
    }

    @Override
    public Collection<Question> getAll() {
        throw new UnsupportedOperationException("Эта функция не поддерживается");
    }

    @Override
    public Question getRandomQuestion() {
        int first = getRandomInt(-10, 11);
        int second = getRandomInt(-10, 11);
        int act = getRandomInt(1, 5);
        Question question = new Question();
        switch (act) {
            case 1:
                question.setQuestion(String.format("%d + %d = ?", first, second));
                question.setAnswer(String.format("%d + %d = %d", first, second, first + second));
                break;
            case 2:
                question.setQuestion(String.format("%d - %d = ?", first, second));
                question.setAnswer(String.format("%d - %d = %d", first, second, first - second));
                break;

            case 3:
                question.setQuestion(String.format("%d * %d = ?", first, second));
                question.setAnswer(String.format("%d * %d = %d", first, second, first * second));
                break;

            case 4:
                if (second == 0) {
                    second++;
                }
                String result = new DecimalFormat("#.######").format((float) first / second);
                question.setQuestion(String.format("%d / %d = ?", first, second));
                question.setAnswer(String.format("%d / %d = %s", first, second, result));
                break;
        }
        return question;
    }

    public int getRandomInt(int origin, int bound) {
        if (random == null) {
            random = new Random();
        }
        return random.nextInt(origin, bound);
    }
}