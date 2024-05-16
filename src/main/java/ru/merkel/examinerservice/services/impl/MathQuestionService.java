package ru.merkel.examinerservice.services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.merkel.examinerservice.exceptions.QuestionNotFoundException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.repositiories.QuestionRepository;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    private final Random random = new Random();
    private final QuestionRepository mathQuestionRepository;

    public MathQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.mathQuestionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return mathQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {

        return mathQuestionRepository.remove(question);
    }

    @Override
    public void removeAll() {
        mathQuestionRepository.removeAll();
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (!mathQuestionRepository.getAll().isEmpty()) {
            List<Question> questionList = new ArrayList<>(mathQuestionRepository.getAll());
            return questionList.get(random.nextInt(questionList.size()));
        }
        throw new QuestionNotFoundException("В списке нет ни одного вопроса");
    }
}
