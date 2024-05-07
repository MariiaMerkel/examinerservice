package ru.merkel.examinerservice.services.impl;

import org.springframework.stereotype.Service;
import ru.merkel.examinerservice.exceptions.ShortageOfQuestionsException;
import ru.merkel.examinerservice.models.Question;
import ru.merkel.examinerservice.services.ExaminerService;
import ru.merkel.examinerservice.services.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random = new Random();
    private QuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount <= questionService.getAll().size()) {
            Collection<Question> questions = new HashSet<>();
            while (amount != questions.size()) {
                questions.add(questionService.getRandomQuestion());
            }
            return questions;
        } else {
            throw new ShortageOfQuestionsException("В списке недостаточно вопросов, чтобы заполнить экзаменационный билет необходимым количеством уникальных вопросов");
        }
    }
}
