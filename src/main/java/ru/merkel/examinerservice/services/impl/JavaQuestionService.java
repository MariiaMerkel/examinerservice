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
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();

    private final QuestionRepository javaQuestionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.javaQuestionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public void removeAll() {
        javaQuestionRepository.removeAll();
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (!javaQuestionRepository.getAll().isEmpty()) {
            List<Question> questionList = new ArrayList<>(javaQuestionRepository.getAll());
            return questionList.get(random.nextInt(questionList.size()));
        }
        throw new QuestionNotFoundException("В списке нет ни одного вопроса");
    }
}
